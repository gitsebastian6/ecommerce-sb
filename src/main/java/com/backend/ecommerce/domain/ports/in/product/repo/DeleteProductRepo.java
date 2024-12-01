package com.backend.ecommerce.domain.ports.in.product.repo;

import java.util.UUID;

public interface DeleteProductRepo {
    boolean deleteProduct(UUID productId);
}
