package com.backend.ecommerce.domain.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private UUID id;
    private String description;
    // public Currency(String description) {
    //     this.description = description;
    // }
}
