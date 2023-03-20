package com.ecommerce.OrdersMicroservice.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.OrdersMicroservice.Domain.Entities.OrderEntity;

public interface OrdersRepository extends JpaRepository<OrderEntity, String> {

    OrderEntity findOneByOrderID(Object orderID);

}