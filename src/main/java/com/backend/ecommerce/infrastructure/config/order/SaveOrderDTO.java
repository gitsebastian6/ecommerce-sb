package com.backend.ecommerce.infrastructure.config.order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveOrderDTO {
    private LocalDate date;
    private List<UUID> products;
    private UUID customer;
}
