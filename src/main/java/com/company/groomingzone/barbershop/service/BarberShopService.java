package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;

public interface BarberShopService {
    BarberShop createBarberShop(CreateBarberShopCommand command, Long requestMemberId);
}
