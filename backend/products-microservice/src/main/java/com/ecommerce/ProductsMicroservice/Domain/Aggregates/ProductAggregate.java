package com.ecommerce.ProductsMicroservice.Domain.Aggregates;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.ecommerce.ProductsMicroservice.Domain.Commands.CreateProductCommand;
import com.ecommerce.ProductsMicroservice.Domain.Events.ProductCreatedEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productID;

    private String name;
    private BigDecimal price;
    private Integer quantity;

    // handler for createProductCommand
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        var productCreatedEvent= new ProductCreatedEvent( );
            BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void onProductCreated(ProductCreatedEvent event) {
        this.productID= event.getProductID( );

        this.name= event.getProductName( );
        this.price= event.getProductPrice( );
        this.quantity= event.getProductQuantity( );
    }

}