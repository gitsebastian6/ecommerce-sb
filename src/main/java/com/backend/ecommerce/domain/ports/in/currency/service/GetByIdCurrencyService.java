package com.backend.ecommerce.domain.ports.in.currency.service;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Currency;

public interface GetByIdCurrencyService {
    Optional<Currency> getById(UUID id);
}
