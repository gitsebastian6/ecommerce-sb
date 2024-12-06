package com.backend.ecommerce.infrastructure.config.security;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.adapters.jpa.category.repositories.JpaCategoryRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.currency.repositories.JpaCurrencyRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.role.repositories.JpaRoleRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.user.repositories.JpaUserRepository;
import com.backend.ecommerce.infrastructure.config.company.CompanyRepo;
import com.backend.ecommerce.infrastructure.entities.CategoryEntity;
import com.backend.ecommerce.infrastructure.entities.CompanyEntity;
import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;
import com.backend.ecommerce.infrastructure.entities.RoleEntity;
import com.backend.ecommerce.infrastructure.entities.UserEntity;

import jakarta.transaction.Transactional;
@Component
public class SetupDataLoader  implements
  ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
        private CompanyRepo companyRepo;
    @Autowired
    private JpaCategoryRepository categoryRepository;

    @Autowired
    private JpaCurrencyRepository currencyRepository;

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

        boolean isEmptyUser = userRepository.findByUsername("admin@test.com").isEmpty();
        
        UUID uuid = UUID.fromString("363a7a35-7361-4511-bd5b-e740b0bc00f6");
        if (companyRepo.findById(uuid).isEmpty()){
            CompanyEntity companyEntity = new CompanyEntity(uuid, 1212121212L, "TECH", "CRA ", "12313123", null);
            companyRepo.save(companyEntity);
        }

        if (isEmptyUser) {
            UserEntity user = new UserEntity("admin@test.com", passwordEncoder.encode("test"));
            user.setAuthorities(setRole);
            user.setEnabled(true);
            userRepository.save(user);
           
            CurrencyEntity currencyEntity = new CurrencyEntity("COP");
            currencyRepository.save(currencyEntity);
            
            CurrencyEntity currencyEntity2 = new CurrencyEntity("US");
            currencyRepository.save(currencyEntity2);

            CategoryEntity categoryEntity = new CategoryEntity("ROPA");
            categoryRepository.save(categoryEntity);

            CategoryEntity categoryEntity2 = new CategoryEntity("CELULARES");
            categoryRepository.save(categoryEntity2);
            
            

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
