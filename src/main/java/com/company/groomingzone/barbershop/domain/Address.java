package com.company.groomingzone.barbershop.domain;


//머시꺵이들 들어가야하지 않을까?
public record Address(
        String address
) {

    public static Address of(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        return new Address(address);
    }
}
