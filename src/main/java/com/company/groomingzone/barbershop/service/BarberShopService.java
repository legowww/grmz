package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.domain.BarberShopInfo;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import com.company.groomingzone.common.repository.ListQueryResponse;

public interface BarberShopService {
    BarberShop createBarberShop(CreateBarberShopCommand command, Long requestMemberId);

    ListQueryResponse<BarberShopInfo> readBarberShopList(BarberShopSearchCondition condition);

    BarberShop readBarberShop(Long id);
}
