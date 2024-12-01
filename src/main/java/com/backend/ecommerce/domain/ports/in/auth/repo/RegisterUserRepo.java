package com.backend.ecommerce.domain.ports.in.auth.repo;

import com.backend.ecommerce.domain.ports.in.auth.dtos.SaveUserDTO;


public interface RegisterUserRepo {
    void register(SaveUserDTO request);
}
