package com.backend.ecommerce.infrastructure.config.category;

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

import com.backend.ecommerce.infrastructure.entities.CategoryEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryBusiness categoryBusiness; 

    @Autowired
    public CategoryController(CategoryBusiness categoryBusiness) {
        this.categoryBusiness = categoryBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<CategoryEntity>>> getCurrencies(){
        return Mono.just(ResponseEntity.ok(categoryBusiness.getCategories()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CategoryEntity>>  getByIdCategory(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(categoryBusiness.getByIdCategory(id)));
    }
    @PostMapping("/")
    public ResponseEntity<Void> createCategory(@RequestBody SaveCategoryDTO createDtoCategory){
        categoryBusiness.create(createDtoCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdCategory(@PathVariable("id") UUID id,  @RequestBody SaveCategoryDTO createDtoCategory){
        categoryBusiness.update(id, createDtoCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdCategory(@PathVariable("id") UUID id){
        categoryBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
