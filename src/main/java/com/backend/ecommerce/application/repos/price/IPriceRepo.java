package com.backend.ecommerce.application.repos.price;

import com.backend.ecommerce.domain.ports.in.price.dtos.PriceSaveDTO;

public interface IPriceRepo {
    void  createPrice(PriceSaveDTO price);
}
