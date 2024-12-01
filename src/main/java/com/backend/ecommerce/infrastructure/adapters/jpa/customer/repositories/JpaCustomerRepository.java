package com.backend.ecommerce.infrastructure.adapters.jpa.customer.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CustomerEntity;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID>  {
    
}
