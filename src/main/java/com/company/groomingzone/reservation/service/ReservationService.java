package com.company.groomingzone.reservation.service;


import com.company.groomingzone.barbershopschedule.service.BarberShopScheduleReader;
import com.company.groomingzone.barbershopschedule.domain.BarberShopSchedule;
import com.company.groomingzone.barbershopstyle.domain.BarberShopStyle;
import com.company.groomingzone.barbershopstyle.service.BarberShopStyleReader;
import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {

//    private final BarberShopReader barberShopReader;
    private final BarberShopScheduleReader barberShopScheduleReader;
    private final BarberShopStyleReader barberShopStyleReader;
    private final ReservationStateMachine reservationStateMachine;


    public Long requestReservation(Long customerId, ReservationTarget reservationTarget) {
//        BarberShop barberShop = barberShopReader.read(reservationTarget.barberShopId());
        Long barberShopId = null; // TODO: BarberShop.getId()
        BarberShopSchedule barberShopSchedule = barberShopScheduleReader.read(reservationTarget.barberShopScheduleId());
        BarberShopStyle barberShopStyle = barberShopStyleReader.read(reservationTarget.barberShopStyleId());

        return reservationStateMachine.request(
                Reservation.of(
                        customerId, 
                        barberShopSchedule.getBarberId(),
                        barberShopId,
                        barberShopSchedule.getId(),
                        barberShopStyle.getId()
                )
        );
    }
}
