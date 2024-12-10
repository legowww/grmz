package com.company.groomingzone.barbershopschedule.service;

import com.company.groomingzone.barbershopschedule.domain.BarberShopSchedule;
import com.company.groomingzone.barbershopschedule.domain.BarberShopScheduleRepository;
import com.company.groomingzone.barbershopschedule.domain.BarberShopScheduleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class BarberShopScheduleReader {

    private final BarberShopScheduleRepository barberShopScheduleRepository;
    private final BarberShopScheduleValidator barberShopScheduleValidator;


    public BarberShopSchedule read(Long barberShopScheduledId) {
        BarberShopSchedule barberShopSchedule = barberShopScheduleRepository.findById(barberShopScheduledId);
        barberShopScheduleValidator.validateScheduleAvailability(barberShopSchedule);

        return barberShopSchedule;
    }
}

