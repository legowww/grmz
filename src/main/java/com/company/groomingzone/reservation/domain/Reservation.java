package com.company.groomingzone.reservation.domain;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.schedule.domain.Schedule;
import com.company.groomingzone.style.domain.Style;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Reservation {

    private Long id;
    private Long customerId;
    private Long barberId;
    private Long barberShopId;
    private Long barberShopScheduleId;
    private Long barberShopStyleId;
    private ReservationStatus reservationStatus;


    public static Reservation of(Long customerId, BarberShop barberShop, Schedule schedule, Style style) {
        return new ReservationBuilder()
                .customerId(customerId)
                .barberId(schedule.getBarberId())
                .barberShopId(barberShop.getId())
                .barberShopScheduleId(schedule.getId())
                .barberShopStyleId(style.getId())
                .reservationStatus(ReservationStatus.REQUESTED)
                .build();
    }
}
