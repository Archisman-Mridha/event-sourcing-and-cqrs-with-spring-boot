package com.ecommerce.ProductsMicroservice.Domain.Queries;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.ecommerce.ProductsMicroservice.Domain.Entities.ProductEntity;
import com.ecommerce.ProductsMicroservice.Domain.Events.ProductCreatedEvent;
import com.ecommerce.ProductsMicroservice.Domain.Repositories.ProductsRepository;

@Component // so that Spring Boot auto detects and includes this class
public class ProductEventsHandler {

    private final ProductsRepository productsRepository;

    public ProductEventsHandler(ProductsRepository productsRepository) {
        this.productsRepository= productsRepository;}

    /*
        Persists the newly created product in the read database

        Since we are using CQRS (Command Query Responsibility Seggregation), this is considered as part of the query
        responsibility.
    */
    @EventHandler
    public void onProductCreated(ProductCreatedEvent event) {

        var productEntity= ProductEntity.builder( )
            .id(event.getProductID( ))
            .name(event.getProductName( ))
            .price(event.getProductPrice( ))
            .quantity(event.getProductQuantity( ))
                .build( );

        this.productsRepository.save(productEntity);
    }

}