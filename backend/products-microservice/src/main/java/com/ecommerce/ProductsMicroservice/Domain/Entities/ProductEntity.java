package com.ecommerce.ProductsMicroservice.Domain.Entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name= "products") // if table doesn't exist, then it will be created by JPA
public class ProductEntity {

    @Id
    @Column(unique = true)
    private String id;

    @Column(unique = true)
    private String name;
    private BigDecimal price;
    private Integer quantity;

}