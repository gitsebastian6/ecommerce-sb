package com.backend.ecommerce.infrastructure.entities;

import java.util.UUID;

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
@Table(name="price")
public class PriceEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private Long value;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="currency_id")
    private CurrencyEntity currency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private ProductEntity product;

    // public PriceEntity(Long value, CurrencyEntity currencies) {
    //     this.value = value;
    //     this.currencies = currencies;
    // }
    // public Price toDomainModel() {
    //     return new Price(id, value, currency.toDomainModel());
    // }
    // public PriceEntity fromModelToEntity() {
    //     return new PriceEntity(value, currencies);
    // }
}
