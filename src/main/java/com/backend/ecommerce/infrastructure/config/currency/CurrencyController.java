package com.backend.ecommerce.infrastructure.config.currency;

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

import com.backend.ecommerce.infrastructure.entities.CurrencyEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyBusiness currencyBusiness; 
    
    @Autowired
    public CurrencyController(CurrencyBusiness currencyBusiness) {
        this.currencyBusiness = currencyBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<CurrencyEntity>>> getCurrencies(){
        return Mono.just(ResponseEntity.ok(currencyBusiness.getCurrencies()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CurrencyEntity>>  getByIdCurrency(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(currencyBusiness.getByIdCurrency(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createCurrency(@RequestBody SaveCurrencyDTO createDtoCurrency){
        currencyBusiness.create(createDtoCurrency);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdCurrency(@PathVariable("id") UUID id,  @RequestBody SaveCurrencyDTO createDtoCurrency){
        currencyBusiness.update(id, createDtoCurrency);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdCurrency(@PathVariable("id") UUID id){
        currencyBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
