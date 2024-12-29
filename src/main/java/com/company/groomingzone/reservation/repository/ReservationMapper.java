package com.company.groomingzone.reservation.repository;

import com.company.groomingzone.reservation.domain.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation mapToDomainEntity(ReservationEntity reservationEntity) {
        return null;
    }


    public ReservationEntity mapToDatabaseEntity(Reservation reservation) {
        return ReservationEntity.of(
                reservation.getId(),
                reservation.getCustomerId(),
                reservation.getBarberId(),
                reservation.getBarberShopId(),
                reservation.getBarberShopScheduleId(),
                reservation.getBarberShopStyleId(),
                reservation.getReservationStatus());

    }
}
