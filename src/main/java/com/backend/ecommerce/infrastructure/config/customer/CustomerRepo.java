package com.backend.ecommerce.infrastructure.config.customer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, UUID>  {
    
}
