package com.backend.ecommerce.application.usecases.product;

import java.util.List;

import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.in.product.service.GetAllProductsService;
import com.backend.ecommerce.domain.ports.out.product.ProductServicePort;

public class GetAllProductUseCaseImpl implements GetAllProductsService{

    private final ProductServicePort productServicePort;

    public GetAllProductUseCaseImpl(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public List<Product> getAllProducts() {
        return productServicePort.findAll();
    }
    
}
