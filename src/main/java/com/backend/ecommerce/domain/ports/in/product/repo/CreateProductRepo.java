package com.backend.ecommerce.domain.ports.in.product.repo;
import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;

public interface CreateProductRepo {
    void createProduct(ProductSaveDTO product);
}
