package com.backend.ecommerce.domain.ports.out.currency;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Currency;

public interface CurrencyServicePort {
    Optional<Currency> getById(UUID id);    
}
