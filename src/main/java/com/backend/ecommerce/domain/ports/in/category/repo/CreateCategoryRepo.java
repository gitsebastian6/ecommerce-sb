package com.backend.ecommerce.domain.ports.in.category.repo;

import com.backend.ecommerce.domain.ports.in.category.dto.CategorySaveDTO;

public interface CreateCategoryRepo {
    void createProduct(CategorySaveDTO product);
}
