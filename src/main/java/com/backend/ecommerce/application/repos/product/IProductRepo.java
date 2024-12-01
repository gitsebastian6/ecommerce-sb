package com.backend.ecommerce.application.repos.product;

import java.util.UUID;

import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;


public interface IProductRepo {
    void  createProduct(ProductSaveDTO product);
    Boolean deleteByIdProduct(UUID productId);
}
