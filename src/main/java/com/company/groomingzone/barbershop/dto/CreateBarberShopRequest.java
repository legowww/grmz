package com.company.groomingzone.barbershop.dto;

public record CreateBarberShopRequest(
        String ownerId,
        String name,
        String address,
        String phone,
        String introduction,
        double latitude,
        double longitude
) {

}
