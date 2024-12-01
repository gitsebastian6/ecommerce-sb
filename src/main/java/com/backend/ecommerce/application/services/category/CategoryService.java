package com.backend.ecommerce.application.services.category;

import java.util.List;

import com.backend.ecommerce.domain.models.Category;
import com.backend.ecommerce.domain.ports.in.category.service.GetAllCategoriesService;

public class CategoryService implements ICategoryService {

    private final GetAllCategoriesService getAllCategoriesService;


    public CategoryService(GetAllCategoriesService getAllCategoriesService) {
        this.getAllCategoriesService = getAllCategoriesService;
    }

    @Override
    public List<Category> getAll() {
        return getAllCategoriesService.getAll();
    }
}
