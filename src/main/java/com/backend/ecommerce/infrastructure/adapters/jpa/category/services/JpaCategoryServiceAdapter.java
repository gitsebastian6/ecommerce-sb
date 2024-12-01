package com.backend.ecommerce.infrastructure.adapters.jpa.category.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.backend.ecommerce.domain.ports.out.category.CategoryServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.category.repositories.JpaCategoryRepository;
import com.backend.ecommerce.infrastructure.entities.CategoryEntity;
import com.backend.ecommerce.domain.models.Category;

public class JpaCategoryServiceAdapter implements CategoryServicePort {

    private final JpaCategoryRepository jpaCategoryRepository;

    public JpaCategoryServiceAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll().stream()
                .map(category -> new Category(category.getDescription())).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryEntity> getById(UUID id) {
        if (jpaCategoryRepository.existsById(id)) {
            return jpaCategoryRepository.findById(id);
        }
        return Optional.empty();
    }
    
}
