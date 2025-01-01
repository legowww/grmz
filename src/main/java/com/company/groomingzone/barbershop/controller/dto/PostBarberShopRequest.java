package com.company.groomingzone.barbershop.controller.dto;

import java.math.BigDecimal;

public record PostBarberShopRequest(
        Long ownerId,
        String name,
        String address,
        String phone,
        String introduction,
        BigDecimal latitude,
        BigDecimal longitude
) {

}
