package com.backend.ecommerce.infrastructure.adapters.jpa.price.services;

import java.util.Optional;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Currency;
import com.backend.ecommerce.domain.models.Price;
import com.backend.ecommerce.domain.ports.out.price.PriceServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.price.repositories.JpaPriceRepository;

public class JpaPriceServiceAdapter implements PriceServicePort {
    private final JpaPriceRepository jpaPriceRepository;
    public JpaPriceServiceAdapter(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }
    @Override
    public Optional<Price> getById(UUID id) {
        if(jpaPriceRepository.existsById(id)){
             return jpaPriceRepository.findById(id).map(price -> {
                Currency currency = new Currency();
                currency.setId(price.getCurrency().getId());
                currency.setDescription(price.getCurrency().getDescription());
                return new Price(id, price.getValue(), currency, null);
             });
        }
        return Optional.empty();
    }
    
}
