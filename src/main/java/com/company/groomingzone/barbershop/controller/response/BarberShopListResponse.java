package com.company.groomingzone.barbershop.controller.response;


import com.company.groomingzone.barbershop.domain.BarberShopInfo;

public record BarberShopListResponse(
        Long id,
        String name,
        String barberShopImageUrl
) {

    public static BarberShopListResponse from(BarberShopInfo barberShopInfo) {
        return new BarberShopListResponse(
                barberShopInfo.id(),
                barberShopInfo.name(),
                barberShopInfo.barberShopImageUrl()
        );
    }
}
