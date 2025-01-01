package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.repository.BarberShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class BarberShopFinder {

    private final BarberShopRepository repository;

    public BarberShop findById(Long barberShopId) {
        return repository.findById(barberShopId);
    }
}
