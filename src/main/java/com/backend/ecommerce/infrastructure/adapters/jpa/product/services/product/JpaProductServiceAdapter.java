package com.backend.ecommerce.infrastructure.adapters.jpa.product.services.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.out.product.ProductServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.product.repositories.JpaProductRepository;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

@Component
public class JpaProductServiceAdapter implements ProductServicePort {

    private final JpaProductRepository jpaProductService;

    public JpaProductServiceAdapter(JpaProductRepository jpaProductService) {
        this.jpaProductService = jpaProductService;
    }

    @Override
    public List<Product> findAll() {
        return jpaProductService.findAll().stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductEntity> getById(UUID productId) {
        if(jpaProductService.existsById(productId)){
            return jpaProductService.findById(productId);
        }
        return Optional.empty();
    }

}