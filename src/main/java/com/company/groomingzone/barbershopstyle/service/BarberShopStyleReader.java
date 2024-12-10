package com.company.groomingzone.barbershopstyle.service;

import com.company.groomingzone.barbershopstyle.domain.BarberShopStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class BarberShopStyleReader {

    public BarberShopStyle read(Long barberShopStyleId) {
        return new BarberShopStyle();
    }
}
