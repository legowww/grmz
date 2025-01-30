package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.dto.response.BarberShopDetailResponse;
import com.company.groomingzone.barbershop.dto.response.BarberShopListResponse;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import com.company.groomingzone.common.repository.querydsl.ScrollResponse;

public interface BarberShopService {
    BarberShop createBarberShop(CreateBarberShopCommand command, Long requestMemberId);

    ScrollResponse<BarberShopListResponse> readBarberShopList(BarberShopSearchCondition condition);

    BarberShopDetailResponse findById(Long id);
}
