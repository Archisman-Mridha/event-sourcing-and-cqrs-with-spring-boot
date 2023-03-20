package com.ecommerce.OrdersMicroservice.Domain.Entities;

import com.ecommerce.OrdersMicroservice.Domain.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "orders")
public class OrderEntity {

    @Id
    @Column(unique = true)
    public String orderID;

    private String productID;
    private int productQuantity;
    private String consumerID;
    private String addressID;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}