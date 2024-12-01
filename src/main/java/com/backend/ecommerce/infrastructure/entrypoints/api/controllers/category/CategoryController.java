package com.backend.ecommerce.infrastructure.entrypoints.api.controllers.category;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.backend.ecommerce.application.services.category.ICategoryService;
import com.backend.ecommerce.domain.models.Category;

import reactor.core.publisher.Mono;

public class CategoryController {
    
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService2) {
        this.categoryService = categoryService2;
    }

    @GetMapping
    public Mono<ResponseEntity<List<Category>>> getCategories(){
        return Mono.just(ResponseEntity.ok(categoryService.getAll()));
    }
}
