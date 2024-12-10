package com.company.groomingzone.barbershopschedule.repository;


import com.company.groomingzone.barbershopschedule.domain.BarberShopSchedule;
import org.springframework.stereotype.Component;

@Component
public class BarberShopScheduleMapper {

    public BarberShopSchedule mapToDomainEntity(BarberShopScheduleEntity barberShopScheduleEntity) {
        return new BarberShopSchedule();
    }

    public BarberShopScheduleEntity mapToDatabaseEntity(BarberShopSchedule barberShopSchedule) {
        return new BarberShopScheduleEntity();
    }
}
