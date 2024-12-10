package com.company.groomingzone.barbershop.domain;

public record Name(
        String name
) {

    public static Name of(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return new Name(name);
    }
}
