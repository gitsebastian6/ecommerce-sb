package com.backend.ecommerce.application.usecases.auth;

import com.backend.ecommerce.domain.ports.in.auth.dtos.SaveUserDTO;
import com.backend.ecommerce.domain.ports.in.auth.repo.RegisterUserRepo;
import com.backend.ecommerce.domain.ports.out.auth.AuthRepositoryPort;

public class RegisterUseCaseImpl implements RegisterUserRepo {
        private final AuthRepositoryPort userRepositoryPort;

    public RegisterUseCaseImpl(AuthRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void register(SaveUserDTO saveUserDTO) {
        userRepositoryPort.register(saveUserDTO);
    }

}
