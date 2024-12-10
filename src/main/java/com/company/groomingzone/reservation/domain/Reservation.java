package com.company.groomingzone.reservation.domain;

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


    public static Reservation of(Long customerId, Long barberId, Long barberShopId, Long barberShopScheduleId, Long barberShopStyleId) {
        return new ReservationBuilder()
                .customerId(customerId)
                .barberId(barberId)
                .barberShopId(barberShopId)
                .barberShopScheduleId(barberShopScheduleId)
                .barberShopStyleId(barberShopStyleId)
                .reservationStatus(ReservationStatus.REQUESTED)
                .build();
    }
}
