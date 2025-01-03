package com.company.groomingzone.style.domain;

import java.math.BigDecimal;

public record CreateStyle(
        Long barberShopId,
        Long barberId,
        String name,
        BigDecimal price,
        String description,
        String url
) {
}
