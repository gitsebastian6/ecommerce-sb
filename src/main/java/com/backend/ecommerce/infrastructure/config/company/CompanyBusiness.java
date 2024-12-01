package com.backend.ecommerce.infrastructure.config.company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.entities.CompanyEntity;
@Component
public class CompanyBusiness {
    
    private final CompanyRepo companyRepo;


    @Autowired
    public CompanyBusiness(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<CompanyEntity> getCompanies(){
        return companyRepo.findAll();
    }

    public CompanyEntity getByIdCompany(UUID id){
        return companyRepo.findById(id).get();
    }

    public void create(SaveCompanyDTO saveCompanyDTO){
        CompanyEntity companyEntity = new CompanyEntity(
            saveCompanyDTO.getNit(),
            saveCompanyDTO.getName(),
            saveCompanyDTO.getAddress(),
            saveCompanyDTO.getPhone());
        companyRepo.save(companyEntity);
    }

    public void update(UUID id, SaveCompanyDTO saveCompanyDTO){
        Optional<CompanyEntity> companyExist = companyRepo.findById(id);
        if(companyExist.isPresent()){
            CompanyEntity companySave = companyExist.get();
            companySave.setNit(saveCompanyDTO.getNit());
            companySave.setName(saveCompanyDTO.getName());
            companySave.setAddress(saveCompanyDTO.getAddress());
            companySave.setPhone(saveCompanyDTO.getPhone());
            companyRepo.save(companySave);
        }
    }

    public void delete(UUID id){
        companyRepo.deleteById(id);
    }
}
