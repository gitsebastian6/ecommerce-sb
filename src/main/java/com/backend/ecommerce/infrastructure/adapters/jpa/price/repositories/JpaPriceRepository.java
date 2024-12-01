package com.backend.ecommerce.infrastructure.adapters.jpa.price.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.PriceEntity;


@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, UUID>  {
    
}
