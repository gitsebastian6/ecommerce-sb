package com.backend.ecommerce.domain.ports.out.company;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.infrastructure.entities.CompanyEntity;

public interface CompanyServicePort {
    Optional<CompanyEntity> getById(UUID id);
}
