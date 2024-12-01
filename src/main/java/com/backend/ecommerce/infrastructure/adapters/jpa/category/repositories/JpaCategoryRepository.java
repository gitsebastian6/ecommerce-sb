package com.backend.ecommerce.infrastructure.adapters.jpa.category.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CategoryEntity;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, UUID>  {
    
}
