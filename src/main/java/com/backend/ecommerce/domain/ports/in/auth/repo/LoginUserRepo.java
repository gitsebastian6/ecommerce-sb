package com.backend.ecommerce.domain.ports.in.auth.repo;

import com.backend.ecommerce.domain.ports.in.auth.dtos.LoginDTO;

public interface LoginUserRepo {
    String login(LoginDTO saveUser) throws Exception;
}
