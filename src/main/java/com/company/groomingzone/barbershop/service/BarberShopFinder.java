package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.repository.BarberShopRepository;
import com.company.groomingzone.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Component
public class BarberShopFinder {

    private final BarberShopRepository repository;


    @Transactional(readOnly = true)
    public BarberShop findById(Long barberShopId) {
        return repository.findById(barberShopId);
    }
}
