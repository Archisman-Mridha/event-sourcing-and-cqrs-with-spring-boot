package com.ecommerce.ProductsMicroservice.Adapters.Inbound.HTTP.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ProductsMicroservice.Domain.Entities.ProductEntity;
import com.ecommerce.ProductsMicroservice.Domain.Queries.FindProductsQuery;

@RestController
@RequestMapping("/products")
public class ProductsQueryController {

    @Autowired
    QueryGateway queryGateway;

    @GetMapping
    public List<ProductEntity> getProducts( ) {

        var findProductsQuery= new FindProductsQuery( );
        List<ProductEntity> products= queryGateway.query(
            findProductsQuery,
            ResponseTypes.multipleInstancesOf(ProductEntity.class)
        ).join( );

        return products;
    }

}