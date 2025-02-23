package com.company.groomingzone.barbershop.service;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.service.dto.BarberShopInfoDto;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import com.company.groomingzone.common.repository.ListQueryResponse;

public interface BarberShopService {
    BarberShop createBarberShop(CreateBarberShopCommand command, Long requestMemberId);

    ListQueryResponse<BarberShopInfoDto> readBarberShopList(BarberShopSearchCondition condition);

    BarberShop readBarberShop(Long id);
}
