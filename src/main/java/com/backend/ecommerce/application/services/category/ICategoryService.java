package com.backend.ecommerce.application.services.category;

import java.util.List;

import com.backend.ecommerce.domain.models.Category;

public interface ICategoryService {
    List<Category> getAll();
}
