package com.backend.ecommerce.domain.ports.out.product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public interface ProductServicePort {
    Optional<ProductEntity> getById(UUID productId);
    List<Product> findAll();
}
