package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.dto.response.BarberShopListResponse;
import org.springframework.data.domain.SliceImpl;

public interface BarberShopEntityCustomRepository {

    SliceImpl<BarberShopListResponse> findBarberShopList(BarberShopSearchCondition condition);
}
