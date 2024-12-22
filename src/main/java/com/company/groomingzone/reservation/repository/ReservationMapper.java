package com.company.groomingzone.reservation.repository;

import com.company.groomingzone.reservation.domain.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation mapToDomainEntity(ReservationEntity reservationEntity) {
        return null;
    }


    public ReservationEntity mapToDatabaseEntity(Reservation reservation) {
        return new ReservationEntity.ReservationEntityBuilder()
                .id(reservation.getId())
                .customerId(reservation.getCustomerId())
                .barberId(reservation.getBarberId())
                .barberShopId(reservation.getBarberShopId())
                .barberShopScheduleId(reservation.getBarberShopScheduleId())
                .barberShopStyleId(reservation.getBarberShopStyleId())
                .reservationStatus(reservation.getReservationStatus())
                .build();
    }
}
