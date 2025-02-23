package com.company.groomingzone.barber.service.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.service.BarberQueryRepository;
import com.company.groomingzone.barber.service.BarberRepository;
import com.company.groomingzone.barber.service.BarberService;

import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import com.company.groomingzone.barber.service.dto.BarberSearchCondition;
import com.company.groomingzone.common.repository.ListQueryResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;
    private final BarberQueryRepository barberQueryRepository;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Barber readBarberById(Long barberId) {
        return barberRepository.findById(barberId);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public BarberInfoDto readBarberInfo(Long barberId) {
        return barberQueryRepository.readBarber(barberId);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public ListQueryResponse<BarberInfoDto> readBarberInfoList(BarberSearchCondition condition) {
        return barberQueryRepository.readBarberList(condition);
    }
}
