package com.backend.ecommerce.infrastructure.config.currency;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyEntity, UUID>  {
    
}
