package com.company.groomingzone.barbershop.domain;

import com.company.groomingzone.barber.domain.Barber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BarberShop {

    private final Barber owner;
    private final Name name;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final String introduction;
    private final Location location;

    public static BarberShop of(Barber owner, Name name, Address address, PhoneNumber phoneNumber, String introduction, Location location) {
        return new BarberShop(owner, name, address, phoneNumber, introduction, location);
    }
}
