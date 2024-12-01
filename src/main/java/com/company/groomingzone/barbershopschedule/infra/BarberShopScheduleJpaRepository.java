package com.company.groomingzone.barbershopschedule.infra;


import com.company.groomingzone.barbershopschedule.domain.BarberShopScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BarberShopScheduleJpaRepository implements BarberShopScheduleRepository {

    private final BarberShopScheduleEntityRepository barberShopScheduleJpaRepository;
}
