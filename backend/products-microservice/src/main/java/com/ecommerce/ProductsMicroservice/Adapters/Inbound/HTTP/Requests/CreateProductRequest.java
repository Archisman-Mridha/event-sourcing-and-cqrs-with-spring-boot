package com.ecommerce.ProductsMicroservice.Adapters.Inbound.HTTP.Requests;

import java.math.BigDecimal;

import lombok.Data;

@Data // generates constructur, getters and setters etc.
public class CreateProductRequest {

    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;

}