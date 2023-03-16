package com.ecommerce.ProductsMicroservice.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ProductsMicroservice.Domain.Entities.ProductEntity;

public interface ProductsRepository extends JpaRepository<ProductEntity, String> {

    ProductEntity findByID(String id);
    ProductEntity findByIDOrName(String id, String name);

}