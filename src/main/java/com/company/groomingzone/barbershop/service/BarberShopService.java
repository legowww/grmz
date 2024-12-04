package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.dto.CreateBarberShopRequest;
import com.company.groomingzone.barbershop.dto.response.SingleBarberShopResponse;

public interface BarberShopService {
    SingleBarberShopResponse createBarberShop(CreateBarberShopRequest request, Long requestMemberId);
}
