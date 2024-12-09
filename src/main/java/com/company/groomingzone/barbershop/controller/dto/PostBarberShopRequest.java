package com.company.groomingzone.barbershop.controller.dto;

public record PostBarberShopRequest(
        Long ownerId,
        String name,
        String address,
        String phone,
        String introduction,
        Double latitude,
        Double longitude
) {

}
