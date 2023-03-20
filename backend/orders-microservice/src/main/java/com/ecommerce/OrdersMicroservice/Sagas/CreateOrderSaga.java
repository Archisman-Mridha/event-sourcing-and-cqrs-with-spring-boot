package com.ecommerce.OrdersMicroservice.Sagas;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.OrdersMicroservice.Domain.Events.OrderCreatedEvent;

@Saga
public class CreateOrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderID")
    public void orderCreatedEventHandler(OrderCreatedEvent event) { }

}