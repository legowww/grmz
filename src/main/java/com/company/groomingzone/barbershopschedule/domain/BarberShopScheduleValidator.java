package com.company.groomingzone.barbershopschedule.domain;

import org.springframework.stereotype.Component;

@Component
public class BarberShopScheduleValidator {

    public void validateScheduleAvailability(BarberShopSchedule barberShopSchedule) {
        if (barberShopSchedule.isReserved()) {
            throw new IllegalStateException("이미 예약이 마감된 시간대입니다.");
        }
    }
}
