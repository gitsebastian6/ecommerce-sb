package com.backend.ecommerce.infrastructure.adapters.jpa.product.repositories;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.ProductEntity;


/**
 * [Description JpaProductRepository]
 */
@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {
    
    
}
