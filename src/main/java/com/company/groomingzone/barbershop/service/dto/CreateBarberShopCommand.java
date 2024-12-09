package com.company.groomingzone.barbershop.service.dto;

public record CreateBarberShopCommand(
        Long ownerId,
        String name,
        String address,
        String phone,
        String introduction,
        Double latitude,
        Double longitude
) {

    public static CreateBarberShopCommand of (Long ownerId, String name, String address, String phone, String introduction, Double latitude, Double longitude) {
        return new CreateBarberShopCommand(ownerId, name, address, phone, introduction, latitude, longitude);
    }
}
