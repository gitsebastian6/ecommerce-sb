package com.backend.ecommerce.infrastructure.adapters.jpa.role.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ecommerce.infrastructure.entities.RoleEntity;

@Repository
public interface JpaRoleRepository  extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByAuthority(String authority);
}

