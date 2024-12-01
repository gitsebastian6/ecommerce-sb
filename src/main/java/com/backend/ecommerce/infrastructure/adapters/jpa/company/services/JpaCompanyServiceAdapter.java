package com.backend.ecommerce.infrastructure.adapters.jpa.company.services;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.ports.out.company.CompanyServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.company.repositories.JpaCompanyRepository;
import com.backend.ecommerce.infrastructure.entities.CompanyEntity;

public class JpaCompanyServiceAdapter implements CompanyServicePort {

    private final JpaCompanyRepository jpaCompanyRepository;
    public JpaCompanyServiceAdapter(JpaCompanyRepository jpaCompanyRepository) {
        this.jpaCompanyRepository = jpaCompanyRepository;
    }
    @Override
    public Optional<CompanyEntity> getById(UUID id) {
        if(jpaCompanyRepository.existsById(id)){
             return jpaCompanyRepository.findById(id);

            //  return jpaCompanyRepository.findById(id).map(company -> new Company( company.getNit(), company.getName(), company.getAddress(), company.getPhone()));
        }
        return Optional.empty();
    }
    
}
