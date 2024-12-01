package com.backend.ecommerce.domain.ports.out.price;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Price;

public interface PriceServicePort {
    Optional<Price> getById(UUID id);
}
