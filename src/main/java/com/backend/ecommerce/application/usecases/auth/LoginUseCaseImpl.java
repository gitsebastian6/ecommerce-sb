package com.backend.ecommerce.application.usecases.auth;

import com.backend.ecommerce.domain.ports.in.auth.dtos.LoginDTO;
import com.backend.ecommerce.domain.ports.in.auth.repo.LoginUserRepo;
import com.backend.ecommerce.domain.ports.out.auth.AuthRepositoryPort;

public class LoginUseCaseImpl implements LoginUserRepo {
    private final AuthRepositoryPort authRepositoryPort;

    public LoginUseCaseImpl(AuthRepositoryPort authRepositoryPort) {
        this.authRepositoryPort = authRepositoryPort;
    }

    @Override
    public String login(LoginDTO authDTO) throws Exception {
        return authRepositoryPort.login(authDTO);
    }

}
