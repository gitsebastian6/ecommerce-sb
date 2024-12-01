package com.backend.ecommerce.infrastructure.entities;

import java.util.UUID;

import com.backend.ecommerce.domain.models.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String description;
    public CategoryEntity(String description) {
        this.description = description;
    }
    public Category toDomainModel(){
        return new Category(description);
    } 

}
