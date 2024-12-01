package com.company.groomingzone.barbershopschedule.application;


import com.company.groomingzone.barbershopschedule.domain.BarberShopScheduleRepository;
import com.company.groomingzone.barbershopschedule.infra.BarberShopScheduleQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BarberShopScheduleService {

    private final BarberShopScheduleRepository barberShopScheduleRepository;
    private final BarberShopScheduleQueryRepository barberShopScheduleQueryRepository;
}
