package com.company.groomingzone.barbershop.service.dto;

import java.math.BigDecimal;

public record CreateBarberShopCommand(
        Long ownerId,
        String name,
        String address,
        String phone,
        String introduction,
        BigDecimal latitude,
        BigDecimal longitude
) {

    public static CreateBarberShopCommand of (Long ownerId, String name, String address, String phone, String introduction, BigDecimal latitude, BigDecimal longitude) {
        return new CreateBarberShopCommand(ownerId, name, address, phone, introduction, latitude, longitude);
    }
}
