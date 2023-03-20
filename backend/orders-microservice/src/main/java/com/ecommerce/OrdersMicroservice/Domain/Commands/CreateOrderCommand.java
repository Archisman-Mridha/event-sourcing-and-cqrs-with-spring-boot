package com.ecommerce.OrdersMicroservice.Domain.Commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.ecommerce.OrdersMicroservice.Domain.OrderStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    public final String orderID;

    private final String consumerID;
    private final String productID;
    private final int productQuantity;
    private final String addressID;
    private final OrderStatus orderStatus= OrderStatus.CREATED;

}