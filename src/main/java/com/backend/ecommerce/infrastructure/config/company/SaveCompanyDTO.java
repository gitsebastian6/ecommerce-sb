package com.backend.ecommerce.infrastructure.config.company;

import java.util.List;

import com.backend.ecommerce.infrastructure.entities.ProductEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveCompanyDTO {
    private Long nit;
    private String name;
    private String address;
    private String phone;
    private List<ProductEntity> products; 
}
