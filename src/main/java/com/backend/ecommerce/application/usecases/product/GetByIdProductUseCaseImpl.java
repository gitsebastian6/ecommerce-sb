package com.backend.ecommerce.application.usecases.product;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.in.product.service.GetByIdProductService;
import com.backend.ecommerce.domain.ports.out.product.ProductServicePort;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public class GetByIdProductUseCaseImpl implements GetByIdProductService {

    private final ProductServicePort productServicePort;
    
    public GetByIdProductUseCaseImpl(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Optional<ProductEntity> getByIdProduct(UUID productId) {
        return productServicePort.getById(productId);
    }
    
}
