package com.company.groomingzone.barber.repository.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.repository.BarberEntity;
import org.springframework.stereotype.Component;

@Component
public class BarberMapper {

    public Barber mapToDomainEntity(BarberEntity dbEntity) {
        return new Barber(1L); //TODO 임시로 넣어놓음
    }
}
