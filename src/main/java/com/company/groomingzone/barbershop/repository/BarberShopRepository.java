package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barbershop.domain.BarberShop;

public interface BarberShopRepository {

    BarberShop findById(Long id);

    BarberShop save(BarberShop barberShop);
}
