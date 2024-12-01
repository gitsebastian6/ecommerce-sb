package com.backend.ecommerce.infrastructure.config.price;

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

import com.backend.ecommerce.infrastructure.entities.PriceEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceBusiness priceBusiness; 

    @Autowired
    public PriceController(PriceBusiness priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<PriceEntity>>> getPrices(){
        return Mono.just(ResponseEntity.ok(priceBusiness.getPrices()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PriceEntity>>  getByIdPrice(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(priceBusiness.getByIdPrice(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createPrice(@RequestBody SavePriceDTO createDtoPrice){
        priceBusiness.create(createDtoPrice);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdPrice(@PathVariable("id") UUID id,  @RequestBody SavePriceDTO createDtoPrice){
        priceBusiness.update(id, createDtoPrice);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdPrice(@PathVariable("id") UUID id){
        priceBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
