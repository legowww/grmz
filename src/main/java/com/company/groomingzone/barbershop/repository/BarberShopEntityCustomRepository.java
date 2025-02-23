package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.service.dto.BarberShopInfoDto;
import com.company.groomingzone.common.repository.ListQueryResponse;

public interface BarberShopEntityCustomRepository {

    ListQueryResponse<BarberShopInfoDto> findBarberShopList(BarberShopSearchCondition condition);
}
