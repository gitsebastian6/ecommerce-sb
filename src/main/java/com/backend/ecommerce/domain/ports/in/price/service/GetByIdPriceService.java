package com.backend.ecommerce.domain.ports.in.price.service;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Price;


public interface GetByIdPriceService {
    Optional<Price> getById(UUID priceId);
}
