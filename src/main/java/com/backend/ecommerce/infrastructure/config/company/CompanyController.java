package com.backend.ecommerce.infrastructure.config.company;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ecommerce.infrastructure.entities.CompanyEntity;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyBusiness companyBusiness; 
    
    @Autowired
    public CompanyController(CompanyBusiness companyBusiness) {
        this.companyBusiness = companyBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<CompanyEntity>>> getCompanies(){
        return Mono.just(ResponseEntity.ok(companyBusiness.getCompanies()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CompanyEntity>>  getByIdCompany(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(companyBusiness.getByIdCompany(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createCompany(@RequestBody SaveCompanyDTO createDtoCompany){
        companyBusiness.create(createDtoCompany);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdCompany(@PathVariable("id") UUID id,  @RequestBody SaveCompanyDTO createDtoCompany){
        companyBusiness.update(id, createDtoCompany);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdCompany(@PathVariable("id") UUID id){
        companyBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
