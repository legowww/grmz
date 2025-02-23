package com.company.groomingzone.barbershop.controller.response;


import com.company.groomingzone.barbershop.service.dto.BarberShopInfoDto;

public record BarberShopListResponse(
        Long id,
        String name,
        String barberShopImageUrl
) {

    public static BarberShopListResponse from(BarberShopInfoDto barberShopInfoDto) {
        return new BarberShopListResponse(
                barberShopInfoDto.id(),
                barberShopInfoDto.name(),
                barberShopInfoDto.barberShopImageUrl()
        );
    }
}
