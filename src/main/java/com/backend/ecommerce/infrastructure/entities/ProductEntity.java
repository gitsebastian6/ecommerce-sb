package com.backend.ecommerce.infrastructure.entities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.backend.ecommerce.domain.models.Category;
import com.backend.ecommerce.domain.models.Company;
import com.backend.ecommerce.domain.models.Currency;
import com.backend.ecommerce.domain.models.Price;
import com.backend.ecommerce.domain.models.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String code;
    private String name;
    private String characteristic;
    private Integer quantity;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<PriceEntity> prices;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CategoryEntity> categories;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private CompanyEntity company;

    public ProductEntity(){

    }
    public ProductEntity(String code, String name, String characteristic, Integer quantity, List<PriceEntity> prices,
            List<CategoryEntity> categories, CompanyEntity company) {
        this.code = code;
        this.name = name;
        this.characteristic = characteristic;
        this.quantity = quantity;
        this.prices = prices;
        this.categories = categories;
        this.company = company;
    }

    public Product toDomainModel() {
        List<Price> convertedPrices = prices.stream()
            .map(price -> {
                Currency currency = new Currency();
                currency.setDescription(price.getCurrency().getDescription());
                currency.setId(price.getCurrency().getId());
                return new Price(
                    price.getId(),
                    price.getValue(),
                    currency,
                    null
                );
            })
            .collect(Collectors.toList());

        List<Category> convertedCategories = categories.stream()
            .map(CategoryEntity::toDomainModel)
            .collect(Collectors.toList());
        Company convertedCompany = company.toDomainModel();
                
        return new Product(id, code, name, characteristic, quantity, convertedPrices, convertedCategories, convertedCompany);
    }
    
}
