package com.backend.ecommerce.infrastructure.adapters.auth.dtos;



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
