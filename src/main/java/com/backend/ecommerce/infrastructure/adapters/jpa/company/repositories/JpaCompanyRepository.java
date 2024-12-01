package com.backend.ecommerce.infrastructure.adapters.jpa.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.CompanyEntity;

@Repository
public interface JpaCompanyRepository extends JpaRepository<CompanyEntity, UUID>  {
    
}
