package com.backend.ecommerce.application.usecases.product;

import java.util.UUID;

import com.backend.ecommerce.domain.ports.in.product.repo.DeleteProductRepo;
import com.backend.ecommerce.domain.ports.out.product.ProductRepositoryPort;

public class DeleteProductUseCaseImpl implements DeleteProductRepo{

    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        return productRepositoryPort.deleteById(productId);
    }
    
}
