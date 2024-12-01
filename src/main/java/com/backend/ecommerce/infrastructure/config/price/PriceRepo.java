package com.backend.ecommerce.infrastructure.config.price;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.PriceEntity;

@Repository
public interface PriceRepo extends JpaRepository<PriceEntity, UUID>  {
    
}
