package com.backend.ecommerce.application.repos.auth;

import com.backend.ecommerce.domain.ports.in.auth.dtos.LoginDTO;
import com.backend.ecommerce.domain.ports.in.auth.dtos.SaveUserDTO;

public interface IAuthRepo {
    void register(SaveUserDTO saveUserDTO);
    String  login(LoginDTO loginDTO) throws Exception ;
}
