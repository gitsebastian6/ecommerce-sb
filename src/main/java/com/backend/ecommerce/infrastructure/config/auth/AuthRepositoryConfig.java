package com.backend.ecommerce.infrastructure.config.auth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backend.ecommerce.application.repos.auth.AuthRepo;
import com.backend.ecommerce.application.usecases.auth.LoginUseCaseImpl;
import com.backend.ecommerce.application.usecases.auth.RegisterUseCaseImpl;
import com.backend.ecommerce.domain.ports.out.auth.AuthRepositoryPort;
import com.backend.ecommerce.infrastructure.adapters.jpa.user.repositories.JpaUserRepositoryAdapter;

@Configuration
public class AuthRepositoryConfig {

    @Bean
    public AuthRepo authRepo(
        @Qualifier("authRepositoryPort") AuthRepositoryPort authRepoPort,
        LoginUseCaseImpl loginUseCase, 
        RegisterUseCaseImpl registerUseCase
        ) {
        
        return new AuthRepo(
            new RegisterUseCaseImpl(authRepoPort),
            new LoginUseCaseImpl(authRepoPort)
        );
    }

    @Bean
    public AuthRepositoryPort authRepositoryPort(JpaUserRepositoryAdapter jpaAuthRepositoryAdapter) {
         return jpaAuthRepositoryAdapter;
    }

    @Bean
    public LoginUseCaseImpl loginAuthUseCaseImpl(AuthRepositoryPort authRepositoryPort) {
        return new LoginUseCaseImpl(authRepositoryPort);
    }
    @Bean
    public RegisterUseCaseImpl registerAuthUseCaseImpl(AuthRepositoryPort authRepositoryPort) {
        return new RegisterUseCaseImpl(authRepositoryPort);
    }
}
