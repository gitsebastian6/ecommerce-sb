package com.backend.ecommerce.domain.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private UUID id;
    private String description;
    public Category(String description) {
        this.description = description;
    }

}
