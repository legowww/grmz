package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barbershop.domain.BarberShop;
import org.springframework.stereotype.Component;

@Component
public class BarberShopMapper {

    public BarberShop mapToDomainEntity(BarberShopEntity barberShopEntity) {
        return new BarberShop();
    }

    public BarberShopEntity mapToDatabaseEntity(BarberShop barberShop) {
        return new BarberShopEntity();
    }
}
