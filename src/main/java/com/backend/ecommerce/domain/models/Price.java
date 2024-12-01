package com.backend.ecommerce.domain.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
    private UUID id;
    private Long value;
    private Currency currency;
    private Product product;
    // public Price(UUID id, Long value, Currency currency, Product product) {
    //     this.id = id;
    //     this.value = value;
    //     this.currency = currency;
    //     this.product = product;
    // }
}
