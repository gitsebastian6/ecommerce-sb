package com.backend.ecommerce.domain.models;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private UUID id;
    private Long nit;
    private String name;
    private String address;
    private String phone;
    private List<Product> products;

    public Company(Long nit, String name, String address, String phone) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

}
