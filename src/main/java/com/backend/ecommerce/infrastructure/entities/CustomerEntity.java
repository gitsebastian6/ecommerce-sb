package com.backend.ecommerce.infrastructure.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String name;
    private String typeDocument;
    @Column(unique = true)
    private Long numberDocument;

    public CustomerEntity(String name, String typeDocument, Long numberDocument) {
        this.name = name;
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
    }
}
