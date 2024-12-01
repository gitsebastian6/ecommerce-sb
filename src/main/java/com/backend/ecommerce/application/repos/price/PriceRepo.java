package com.backend.ecommerce.application.repos.price;

import com.backend.ecommerce.domain.ports.in.price.dtos.PriceSaveDTO;
import com.backend.ecommerce.domain.ports.in.price.repo.CreatePriceRepo;
public class PriceRepo implements IPriceRepo {

    private final CreatePriceRepo createPriceRepo;

    public PriceRepo(CreatePriceRepo createPriceRepo) {
        this.createPriceRepo = createPriceRepo;
    }
    @Override
    public void createPrice(PriceSaveDTO price) {
        createPriceRepo.createPrice(price);
    }
}
