package com.backend.ecommerce.infrastructure.adapters.jpa.currency.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;

@Repository
public interface JpaCurrencyRepository extends JpaRepository<CurrencyEntity, UUID>  {
    
}
