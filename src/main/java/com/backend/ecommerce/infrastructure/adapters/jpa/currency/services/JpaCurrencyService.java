package com.backend.ecommerce.infrastructure.adapters.jpa.currency.services;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Currency;
import com.backend.ecommerce.domain.ports.out.currency.CurrencyServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.currency.repositories.JpaCurrencyRepository;

public class JpaCurrencyService implements CurrencyServicePort {

    private final JpaCurrencyRepository jpaCurrencyRepository;
    public JpaCurrencyService(JpaCurrencyRepository jpaCurrencyRepository) {
        this.jpaCurrencyRepository = jpaCurrencyRepository;
    }
    @Override
    public Optional<Currency> getById(UUID id) {
        if(jpaCurrencyRepository.existsById(id)){
             return jpaCurrencyRepository.findById(id).map(currency -> new Currency(
                currency.getId(), currency.getDescription()
             ));
        }
        return Optional.empty();
    }
    
}
