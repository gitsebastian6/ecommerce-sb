package com.backend.ecommerce.domain.ports.out.auth;

import com.backend.ecommerce.domain.ports.in.auth.dtos.LoginDTO;
import com.backend.ecommerce.domain.ports.in.auth.dtos.SaveUserDTO;

public interface AuthRepositoryPort {
    public String login(LoginDTO login) throws Exception;
    void register(SaveUserDTO saveUserDTO);
}
