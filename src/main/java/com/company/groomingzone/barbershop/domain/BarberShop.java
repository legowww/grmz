package com.company.groomingzone.barbershop.domain;

import com.company.groomingzone.barber.domain.Barber;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BarberShop {

    private Long id;
    private Barber owner;
    private Name name;
    private Address address;
    private PhoneNumber phoneNumber;
    private String introduction;
    private Location location;
    private boolean isActive;


    public static BarberShop of(Long id, Barber owner, Name name, Address address,
                                PhoneNumber phoneNumber, String introduction,
                                Location location, boolean isActive) {
        return new BarberShop(id, owner, name, address, phoneNumber, introduction, location, isActive);
    }


    public static BarberShop withOutId(Barber owner, Name name, Address address,
                                       PhoneNumber phoneNumber, String introduction,
                                       Location location, boolean isActive) {
        return new BarberShop(null, owner, name, address, phoneNumber, introduction, location, isActive);
    }
}
