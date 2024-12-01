package com.backend.ecommerce.domain.ports.out.price;

import com.backend.ecommerce.domain.models.Price;

public interface PriceRepositoryPort {
    void save(Price price);
}
