package com.ecommerce.OrdersMicroservice.Adapters.HTTP.Requests;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private String productID;
    private Integer productQuantity;
    private String consumerID;
    private String addressID;

}