package com.backend.ecommerce.infrastructure.config.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.adapters.jpa.role.repositories.JpaRoleRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.user.repositories.JpaUserRepository;
import com.backend.ecommerce.infrastructure.entities.RoleEntity;
import com.backend.ecommerce.infrastructure.entities.UserEntity;

import jakarta.transaction.Transactional;
@Component
public class SetupDataLoader  implements
  ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private JpaUserRepository userRepository;
 
    @Autowired
    private JpaRoleRepository roleRepository;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
        if (alreadySetup)
            return;
 
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("USER");


        Set<RoleEntity> setRole = new HashSet<RoleEntity>();
        RoleEntity adminRole = roleRepository.findByAuthority("ADMIN").get();
        setRole.add(adminRole);
        if (userRepository.findByUsername("admin@test.com").isEmpty()) {
            UserEntity user = new UserEntity(passwordEncoder.encode("test"), "admin@test.com");
            user.setAuthorities(setRole);
            user.setEnabled(true);
            userRepository.save(user);
        }

        alreadySetup = true;
    }

    @Transactional
    RoleEntity createRoleIfNotFound(String name) {
        RoleEntity role = new RoleEntity(name);
        if (roleRepository.findByAuthority(name).isEmpty()) {
            roleRepository.save(role);
        }
        return role;
    }
}
