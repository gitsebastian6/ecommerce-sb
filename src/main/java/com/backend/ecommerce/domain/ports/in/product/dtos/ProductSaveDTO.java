package com.backend.ecommerce.domain.ports.in.product.dtos;

import java.util.List;
import java.util.UUID;

import com.backend.ecommerce.domain.ports.in.price.dtos.PriceSaveDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveDTO {
    private String code;
    private String name;
    private String characteristic;
    private Integer quantity;
    private List<PriceSaveDTO> prices;
    private List<UUID> categories;
    private UUID companyId;

}
