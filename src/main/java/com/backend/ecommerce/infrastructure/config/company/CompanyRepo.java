package com.backend.ecommerce.infrastructure.config.company;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, UUID>  {
    
}
