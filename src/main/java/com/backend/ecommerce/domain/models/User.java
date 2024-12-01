package com.backend.ecommerce.domain.models;

import java.util.Set;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private Set<Role> authorities;

    public User(String email, String password) {
        this.username = email;
        this.password = password;
    }
}
