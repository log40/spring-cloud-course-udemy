package com.lblandi.itemms.features.product;

import java.time.LocalDateTime;

public record ProductDto(
        Long id,
        String name,
        Double price,
        LocalDateTime createdAt
) {
}
