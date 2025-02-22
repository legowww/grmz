package com.company.groomingzone.barbershop.controller.response;


import com.company.groomingzone.barbershop.domain.BarberShop;

public record BarberShopDetailResponse(
        Long id,
        String name,
        String introduction,
        String address,
        boolean isActive,
        int score,
        int reviewCount
) {

    public static BarberShopDetailResponse of(BarberShop barberShop, int score, int reviewCount) {
        return new BarberShopDetailResponse(
                barberShop.getId(),
                barberShop.getName().name(),
                barberShop.getIntroduction(),
                barberShop.getAddress().address(),
                barberShop.isActive(),
                score,
                reviewCount
        );
    }
}
