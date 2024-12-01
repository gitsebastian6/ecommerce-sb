package com.backend.ecommerce.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    private UUID id;
    private String authority;

    public String getAuthority() {
        return authority;
    }
}
