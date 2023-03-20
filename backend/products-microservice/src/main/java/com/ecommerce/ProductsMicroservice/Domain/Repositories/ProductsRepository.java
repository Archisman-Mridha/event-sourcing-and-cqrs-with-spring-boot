package com.ecommerce.ProductsMicroservice.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ProductsMicroservice.Domain.Entities.ProductEntity;

public interface ProductsRepository extends JpaRepository<ProductEntity, String> {

    ProductEntity findOneByID(String id);
    ProductEntity findOneByIDOrName(String id, String name);

}