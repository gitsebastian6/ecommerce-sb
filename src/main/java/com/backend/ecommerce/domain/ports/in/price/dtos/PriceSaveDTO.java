package com.backend.ecommerce.domain.ports.in.price.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSaveDTO {
    private UUID currencyId;
    private Long value;
}
