package com.backend.ecommerce.domain.ports.in.auth.dtos;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveUserDTO {

    private String email;
    private String password;
    private List<String> roles;
} 
