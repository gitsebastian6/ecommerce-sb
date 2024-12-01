package com.backend.ecommerce.domain.ports.in.product.repo;
import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;


public interface UpdateProductRepo {
    Optional<ProductSaveDTO> updateProduct(UUID productId, ProductSaveDTO product);
}
