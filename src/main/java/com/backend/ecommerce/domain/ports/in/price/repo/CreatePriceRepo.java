package com.backend.ecommerce.domain.ports.in.price.repo;

import com.backend.ecommerce.domain.ports.in.price.dtos.PriceSaveDTO;

public interface CreatePriceRepo {
    void createPrice(PriceSaveDTO price);
}
