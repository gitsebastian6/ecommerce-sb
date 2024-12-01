package com.backend.ecommerce.domain.ports.out.role;

import java.util.Optional;

import com.backend.ecommerce.infrastructure.entities.RoleEntity;

public interface RoleRepositoryPort {
     Optional<RoleEntity> findByAuthority(String authority);
}
