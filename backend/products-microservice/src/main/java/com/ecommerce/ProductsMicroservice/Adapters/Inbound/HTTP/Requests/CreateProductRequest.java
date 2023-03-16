package com.ecommerce.ProductsMicroservice.Adapters.Inbound.HTTP.Requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // generates constructur, getters and setters etc.
public class CreateProductRequest {

    @NotBlank(message = "Product name cannot be empty")
    private String productName;

    @Min(value= 1, message= "Product price should be greater than 0")
    private BigDecimal productPrice;

    @Min(value= 1, message= "Product quantity should be greater than 0")
    private Integer productQuantity;

}