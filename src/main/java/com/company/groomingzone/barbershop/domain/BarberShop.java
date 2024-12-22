package com.company.groomingzone.barbershop.domain;

import com.company.groomingzone.barber.domain.Barber;

public record BarberShop(Long id,
                         Barber owner,
                         Name name,
                         Address address,
                         PhoneNumber phoneNumber,
                         String introduction,
                         Location location,
                         boolean isActive) {

    // 조회, 네이밍은 일단 건드리지 않았음
    public static BarberShop of(Long id, Barber owner, Name name, Address address,
        PhoneNumber phoneNumber, String introduction, Location location, boolean isActive) {
        return new BarberShop(id, owner, name, address, phoneNumber, introduction, location, isActive);
    }

    public static BarberShop withOutId(Barber owner, Name name, Address address, PhoneNumber phoneNumber,
        String introduction, Location location, boolean isActive) {
        return new BarberShop(null, owner, name, address, phoneNumber, introduction, location, isActive);
    }
}
