package com.backend.ecommerce.domain.models;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private UUID id;
    private String code;
    private String name;
    private String characteristic;
    private Integer quantity;
    private List<Price> prices;
    private List<Category> categories;
    private Company company;
}
