package com.ecommerce.ProductsMicroservice.Adapters.Inbound.HTTP.Controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ProductsMicroservice.Adapters.Inbound.HTTP.Requests.CreateProductRequest;
import com.ecommerce.ProductsMicroservice.Domain.Commands.CreateProductCommand;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private final CommandGateway commandGateway;

    @Autowired // enabling dependency injection
    public ProductsCommandController(CommandGateway commandGateway) {
        this.commandGateway= commandGateway;}

    @PostMapping
    public void createProduct(@Valid @RequestBody CreateProductRequest request) {

        var createProductCommand= CreateProductCommand.builder( )
            .productID(UUID.randomUUID( ).toString( ))
            .productName(request.getProductName( ))
            .productPrice(request.getProductPrice( ))
            .productQuantity(request.getProductQuantity( ))
                .build( );

        try {
            this.commandGateway.sendAndWait(createProductCommand);

        } catch(Exception exception) {
            // TODO: handle exception
        }
    }

    @PutMapping
    public void updateProduct( ) { }

    @DeleteMapping
    public void deleteProduct( ) { }

}