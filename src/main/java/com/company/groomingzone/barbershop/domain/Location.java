package com.company.groomingzone.barbershop.domain;

import java.math.BigDecimal;

public record Location(
        double latitude,
        double longitude
) {
    public static Location of(BigDecimal latitude, BigDecimal longitude) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("어쩌구 저쩌구");
        }

        return new Location(latitude.doubleValue(), longitude.doubleValue());
    }
}
