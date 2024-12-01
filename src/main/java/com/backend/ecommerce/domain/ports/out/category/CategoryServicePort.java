package com.backend.ecommerce.domain.ports.out.category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Category;
import com.backend.ecommerce.infrastructure.entities.CategoryEntity;

public interface CategoryServicePort {
    List<Category> findAll();
    Optional<CategoryEntity> getById(UUID id);
}