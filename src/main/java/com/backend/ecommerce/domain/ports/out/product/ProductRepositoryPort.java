package com.backend.ecommerce.domain.ports.out.product;

import java.util.UUID;

import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public interface ProductRepositoryPort {
    ProductEntity save(ProductEntity product);
    boolean deleteById(UUID productId);
}