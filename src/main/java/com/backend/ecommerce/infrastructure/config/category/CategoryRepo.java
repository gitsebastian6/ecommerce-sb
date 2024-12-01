package com.backend.ecommerce.infrastructure.config.category;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CategoryEntity;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, UUID>  {
    
}
