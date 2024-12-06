package com.backend.ecommerce.infrastructure.entities;

import java.util.List;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private Long nit;
    private String name;
    private String address;
    private String phone;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore // Ignora los productos al serializar
    private List<ProductEntity> products;

    public CompanyEntity(Long nit, String name, String address, String phone) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Company toDomainModel() {
        return new Company(nit, name, address, phone);
    }

}
