package com.backend.ecommerce.domain.ports.in.product.service;

import java.util.List;

import com.backend.ecommerce.domain.models.Product;

public interface GetAllProductsService {
    
    List<Product> getAllProducts();
}
