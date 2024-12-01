package com.backend.ecommerce.infrastructure.config.category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.entities.CategoryEntity;
@Component
public class CategoryBusiness {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryBusiness(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<CategoryEntity> getCategories(){
        return categoryRepo.findAll();
    }

    public CategoryEntity getByIdCategory(UUID id){
        return categoryRepo.findById(id).get();
    }

    public void create(SaveCategoryDTO saveCategoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity(saveCategoryDTO.getDescription());
        categoryRepo.save(categoryEntity);
    }
    public void update(UUID id, SaveCategoryDTO saveCategoryDTO){
        Optional<CategoryEntity> categoryExist = categoryRepo.findById(id);
        if(categoryExist.isPresent()){
            CategoryEntity categorySave = categoryExist.get();
            categorySave.setDescription(saveCategoryDTO.getDescription());
            categoryRepo.save(categorySave);
        }
    }
    public void delete(UUID id){
        categoryRepo.deleteById(id);
    }
}
