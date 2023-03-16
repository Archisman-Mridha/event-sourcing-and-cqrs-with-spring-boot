package com.ecommerce.ProductsMicroservice.Domain.Commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String productID;

    private final String productName;
    private final BigDecimal productPrice;
    private final Integer productQuantity;

}