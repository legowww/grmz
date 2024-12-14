package com.company.groomingzone.barbershop.domain;

import com.company.groomingzone.barber.domain.Barber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BarberShop {

    private final Long id;
    private final Barber owner;
    private final Name name;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final String introduction;
    private final Location location;

    // 조회, 네이밍은 일단 건드리지 않았음
    public static BarberShop of(Long id, Barber owner, Name name, Address address, PhoneNumber phoneNumber, String introduction, Location location) {
        return new BarberShop(id, owner, name, address, phoneNumber, introduction, location);
    }

    // 생성
    public static BarberShop of(Barber owner, Name name, Address address, PhoneNumber phoneNumber, String introduction, Location location) {
        return new BarberShop(null, owner, name, address, phoneNumber, introduction, location);
    }
}
