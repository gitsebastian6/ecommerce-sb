package com.backend.ecommerce.infrastructure.config.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ecommerce.infrastructure.entities.OrderEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderBusiness orderBusiness; 
    
    @Autowired
    public OrderController(OrderBusiness orderBusiness) {
        this.orderBusiness = orderBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<OrderEntity>>> getOrders(){
        return Mono.just(ResponseEntity.ok(orderBusiness.getOrders()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<OrderEntity>>  getByIdOrder(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(orderBusiness.getByIdOrder(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody SaveOrderDTO createDtoOrder){
        orderBusiness.create(createDtoOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdOrder(@PathVariable("id") UUID id){
        orderBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
