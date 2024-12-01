package com.backend.ecommerce.infrastructure.adapters.jpa.price.repositories;

import java.util.UUID;

import com.backend.ecommerce.domain.models.Price;
import com.backend.ecommerce.domain.ports.out.price.PriceRepositoryPort;
import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;
import com.backend.ecommerce.infrastructure.entities.PriceEntity;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    public JpaPriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public void save(Price price) {
        CurrencyEntity currencyEntity =  new CurrencyEntity(
            price.getCurrency().getId(),
            price.getCurrency().getDescription()
        );

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(price.getProduct().getId());
        PriceEntity priceEntity  = new PriceEntity(
            new UUID(0, 0),
            price.getValue(),
            currencyEntity,
            productEntity
        );
        jpaPriceRepository.save(priceEntity);
    }
    
}
