package com.backend.ecommerce.infrastructure.config.customer;

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

import com.backend.ecommerce.infrastructure.entities.CustomerEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerBusiness customerBusiness; 
    
    @Autowired
    public CustomerController(CustomerBusiness customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<CustomerEntity>>> getCustomers(){
        return Mono.just(ResponseEntity.ok(customerBusiness.getCustomers()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerEntity>>  getByIdCustomer(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(customerBusiness.getByIdCustomer(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createCustomer(@RequestBody SaveCustomerDTO createDtoCustomer){
        customerBusiness.create(createDtoCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdCustomer(@PathVariable("id") UUID id,  @RequestBody SaveCustomerDTO createDtoCustomer){
        customerBusiness.update(id, createDtoCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdCustomer(@PathVariable("id") UUID id){
        customerBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
