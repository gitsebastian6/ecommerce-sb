package com.backend.ecommerce.domain.ports.in.product.service;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public interface GetByIdProductService {
    Optional<ProductEntity> getByIdProduct(UUID productId);
}
