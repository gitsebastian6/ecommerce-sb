package com.backend.ecommerce.domain.models;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String typeDocument;
    private Long numberDocument;

}
