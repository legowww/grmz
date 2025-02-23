package com.company.groomingzone.barber.domain;

import lombok.Builder;

@Builder
public record Barber(
        Long id,
        Long barberShopId,
        String introduction,
        Boolean isActive
) {
}
