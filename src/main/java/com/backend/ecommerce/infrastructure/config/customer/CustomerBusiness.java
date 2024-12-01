package com.backend.ecommerce.infrastructure.config.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.entities.CustomerEntity;

@Component
public class CustomerBusiness {
    
    private final CustomerRepo currencyRepo;


    @Autowired
    public CustomerBusiness(CustomerRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    public List<CustomerEntity> getCustomers(){
        return currencyRepo.findAll();
    }

    public CustomerEntity getByIdCustomer(UUID id){
        return currencyRepo.findById(id).get();
    }

    public void create(SaveCustomerDTO saveCustomerDTO){
        CustomerEntity currencyEntity = new CustomerEntity(saveCustomerDTO.getName(),saveCustomerDTO.getTypeDocument(),saveCustomerDTO.getNumberDocument());
        currencyRepo.save(currencyEntity);
    }

    public void update(UUID id, SaveCustomerDTO saveCustomerDTO){
        Optional<CustomerEntity> currentExist = currencyRepo.findById(id);
        if(currentExist.isPresent()){
            CustomerEntity currentSave = currentExist.get();
            currentSave.setName(saveCustomerDTO.getName());
            currentSave.setNumberDocument(saveCustomerDTO.getNumberDocument());
            currentSave.setTypeDocument(saveCustomerDTO.getTypeDocument());
            currencyRepo.save(currentSave);
        }
    }
    public void delete(UUID id){
        currencyRepo.deleteById(id);
    }
}
