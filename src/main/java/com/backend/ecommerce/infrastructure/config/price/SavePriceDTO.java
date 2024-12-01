package com.backend.ecommerce.infrastructure.config.price;


import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SavePriceDTO {
    private Long value;
    private CurrencyEntity currency;
    private ProductEntity product;
} 

