package com.backend.ecommerce.domain.ports.in.category.service;

import java.util.List;

import com.backend.ecommerce.domain.models.Category;

public interface GetAllCategoriesService {
    List<Category> getAll();
}
