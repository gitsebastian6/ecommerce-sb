package com.backend.ecommerce.application.services.product;

import java.util.List;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Product;

public interface IProductService {
    List<Product> getAllProducts();
    Product getByIdProduct(UUID productId);
}
