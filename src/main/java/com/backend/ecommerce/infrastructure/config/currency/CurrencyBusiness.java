package com.backend.ecommerce.infrastructure.config.currency;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;


@Component
public class CurrencyBusiness {
    
    private final CurrencyRepo currencyRepo;


    @Autowired
    public CurrencyBusiness(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    public List<CurrencyEntity> getCurrencies(){
        return currencyRepo.findAll();
    }

    public CurrencyEntity getByIdCurrency(UUID id){
        return currencyRepo.findById(id).get();
    }

    public void create(SaveCurrencyDTO saveCurrencyDTO){
        CurrencyEntity currencyEntity = new CurrencyEntity(saveCurrencyDTO.getDescription());
        currencyRepo.save(currencyEntity);
    }
    public void update(UUID id, SaveCurrencyDTO saveCurrencyDTO){
        Optional<CurrencyEntity> currentExist = currencyRepo.findById(id);
        if(currentExist.isPresent()){
            CurrencyEntity currentSave = currentExist.get();
            currentSave.setDescription(saveCurrencyDTO.getDescription());
            currencyRepo.save(currentSave);
        }
    }
    public void delete(UUID id){
        currencyRepo.deleteById(id);
    }
}
