package com.company.groomingzone.barber.service;

import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import com.company.groomingzone.barber.service.dto.BarberSearchCondition;
import com.company.groomingzone.common.repository.ListQueryResponse;


public interface BarberQueryRepository {

    BarberInfoDto readBarber(Long barberId);

    ListQueryResponse<BarberInfoDto> readBarberList(BarberSearchCondition condition);
}
