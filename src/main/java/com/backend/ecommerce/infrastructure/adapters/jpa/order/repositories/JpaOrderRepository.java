package com.backend.ecommerce.infrastructure.adapters.jpa.order.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.OrderEntity;
@Repository
public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID>  {
    
}
