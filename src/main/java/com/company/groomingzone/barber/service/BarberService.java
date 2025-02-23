package com.company.groomingzone.barber.service;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.domain.BarberInfo;
import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import com.company.groomingzone.barber.service.dto.BarberSearchCondition;
import com.company.groomingzone.common.repository.ListQueryResponse;

public interface BarberService {

    Barber readBarberById(Long requestMemberId);

    BarberInfoDto readBarberInfo(Long requestMemberId);

    ListQueryResponse<BarberInfoDto> readBarberInfoList(BarberSearchCondition condition);
}
