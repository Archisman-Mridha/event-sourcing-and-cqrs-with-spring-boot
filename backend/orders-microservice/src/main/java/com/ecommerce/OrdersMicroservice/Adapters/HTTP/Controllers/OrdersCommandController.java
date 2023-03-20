package com.ecommerce.OrdersMicroservice.Adapters.HTTP.Controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.OrdersMicroservice.Adapters.HTTP.Requests.CreateOrderRequest;
import com.ecommerce.OrdersMicroservice.Domain.Commands.CreateOrderCommand;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrdersCommandController {

    private final CommandGateway commandGateway;

    @Autowired
    public OrdersCommandController(CommandGateway commandGateway) {
        this.commandGateway= commandGateway;}

    @PostMapping
    public void createOrder(@Valid @RequestBody CreateOrderRequest request) {

        var createOrderCommand= CreateOrderCommand.builder( )
            .orderID(UUID.randomUUID( ).toString( ))
            .productID(request.getProductID( ))
            .productQuantity(request.getProductQuantity( ))
            .consumerID(request.getConsumerID( ))
            .addressID(request.getAddressID( ))
                .build( );

        try {
            commandGateway.sendAndWait(createOrderCommand);

        } catch(Exception exception) { /* TODO: handle exception */ }
    }

}