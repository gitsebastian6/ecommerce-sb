package com.backend.ecommerce.infrastructure.config.order;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, UUID>  {
    
}
