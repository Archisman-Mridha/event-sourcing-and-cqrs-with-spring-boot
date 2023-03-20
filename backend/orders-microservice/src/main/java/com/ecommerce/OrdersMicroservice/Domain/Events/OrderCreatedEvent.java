package com.ecommerce.OrdersMicroservice.Domain.Events;

import com.ecommerce.OrdersMicroservice.Domain.OrderStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreatedEvent {

    private String orderID;
    private String consumerID;
    private String productID;
    private int productQuantity;
    private String addressID;
    private OrderStatus orderStatus;

}