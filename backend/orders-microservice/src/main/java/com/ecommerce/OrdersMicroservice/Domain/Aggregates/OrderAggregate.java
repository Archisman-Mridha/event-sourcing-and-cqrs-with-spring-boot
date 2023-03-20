package com.ecommerce.OrdersMicroservice.Domain.Aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.ecommerce.OrdersMicroservice.Domain.OrderStatus;
import com.ecommerce.OrdersMicroservice.Domain.Commands.CreateOrderCommand;
import com.ecommerce.OrdersMicroservice.Domain.Events.OrderCreatedEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class OrderAggregate {

    private String orderID;
    private String consumerID;
    private String productID;
    private int productQuantity;
    private String addressID;
    private OrderStatus orderStatus;

    // handler for createOrderCommand
    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {

        var orderCreatedEvent= OrderCreatedEvent.builder( )
            .orderID(createOrderCommand.getOrderID( ))
            .consumerID(createOrderCommand.getConsumerID( ))
            .productID(createOrderCommand.getProductID( ))
            .productQuantity(createOrderCommand.getProductQuantity( ))
            .addressID(createOrderCommand.getAddressID( ))
            .orderStatus(createOrderCommand.getOrderStatus( ))
                .build( );

        AggregateLifecycle.apply(orderCreatedEvent);
    }

    // event handlers

    @EventSourcingHandler
    public void onOrderCreated(OrderCreatedEvent event) {

        this.orderID= event.getOrderID( );
        this.consumerID= event.getConsumerID( );
        this.productID= event.getProductID( );
        this.productQuantity= event.getProductQuantity( );
        this.addressID= event.getAddressID( );
        this.orderStatus= event.getOrderStatus( );
    }

}