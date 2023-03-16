package com.ecommerce.ProductsMicroservice.Domain.Events;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCreatedEvent {

    private String productID;

    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;

}