package com.backend.ecommerce.domain.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImage {
    private UUID id;
    private String description;
    public ProductImage(String description) {
        this.description = description;
    }

}
