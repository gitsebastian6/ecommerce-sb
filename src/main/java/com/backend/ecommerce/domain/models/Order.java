package com.backend.ecommerce.domain.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private UUID id;
    private LocalDate date;
    private List<Product> products;
    private Customer customer;
}
