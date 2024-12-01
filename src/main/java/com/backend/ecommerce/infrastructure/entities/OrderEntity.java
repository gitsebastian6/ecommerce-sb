package com.backend.ecommerce.infrastructure.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "local_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate date;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProductEntity> products;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
    public OrderEntity(LocalDate date, List<ProductEntity> products, CustomerEntity customer) {
        this.date = date;
        this.products = products;
        this.customer = customer;
    }
}
