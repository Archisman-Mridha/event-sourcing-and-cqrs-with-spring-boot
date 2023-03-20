package com.ecommerce.OrdersMicroservice.Domain;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.ecommerce.OrdersMicroservice.Domain.Events.OrderCreatedEvent;
import com.ecommerce.OrdersMicroservice.Domain.Repositories.OrdersRepository;

@Component
public class OrderQueriesHandler {

    private final OrdersRepository ordersRepository;

    public OrderQueriesHandler(OrdersRepository ordersRepository) {
        this.ordersRepository= ordersRepository;}

    @EventHandler
    public void onOrderCreated(OrderCreatedEvent event) { }

}