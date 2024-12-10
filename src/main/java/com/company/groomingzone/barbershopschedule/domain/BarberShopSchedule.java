package com.company.groomingzone.barbershopschedule.domain;

import lombok.Getter;

@Getter
public class BarberShopSchedule {

    private Long id;
    private Long barberId;
    private boolean isReserved;

    public boolean isReserved() {
        return this.isReserved;
    }
}
