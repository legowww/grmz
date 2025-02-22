package com.company.groomingzone.barber.service.dto;

public record BarberInfoDto(
        Long id,
        Long barberShopId,
        String introduction,
        Boolean isActive,
        String name
) {
}
