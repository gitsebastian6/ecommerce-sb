package com.backend.ecommerce.infrastructure.entities;

import java.util.UUID;

import com.backend.ecommerce.domain.models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_image")
public class ProductImageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String description;
    
    @Column(nullable = false)
    private String imageUrl; 
    
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "product_id", nullable = false) 
    private ProductEntity product;

   
    public ProductImageEntity(String description, String imageUrl, ProductEntity product) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.product = product;
    }

   
    public Category toDomainModel() {
        return new Category(description); 
    }


}




