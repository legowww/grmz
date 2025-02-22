package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.domain.BarberShopInfo;
import com.company.groomingzone.common.repository.ListQueryResponse;

public interface BarberShopEntityCustomRepository {

    ListQueryResponse<BarberShopInfo> findBarberShopList(BarberShopSearchCondition condition);
}
