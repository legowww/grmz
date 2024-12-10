package com.company.groomingzone.barbershop.domain;

public record Location(
        double latitude,
        double longitude
) {
    public static Location of(Double latitude, Double longitude) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("어쩌구 저쩌구");
        }
        return new Location(latitude, longitude);
    }
}
