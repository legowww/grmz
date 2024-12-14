package com.company.groomingzone.reservation.service;


import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.service.BarberShopFinder;
import com.company.groomingzone.schedule.service.ScheduleFinder;
import com.company.groomingzone.schedule.domain.Schedule;
import com.company.groomingzone.style.domain.Style;
import com.company.groomingzone.style.service.StyleFinder;
import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final BarberShopFinder barberShopFinder;
    private final ScheduleFinder scheduleFinder;
    private final StyleFinder styleFinder;
    private final ReservationWriter reservationWriter;


    public Long save(Long customerId, ReservationTarget reservationTarget) {
        BarberShop barberShop = barberShopFinder.findById(reservationTarget.barberShopId());
        Schedule schedule = scheduleFinder.findAvailabilitySchedule(reservationTarget.scheduleId());
        Style style = styleFinder.findById(reservationTarget.styleId());

        Reservation reservation = Reservation.of(
                customerId,
                schedule.barberId(),
                barberShop.getId(),
                schedule.id(),
                style.id()
        );

        return reservationWriter.save(reservation);
    }
}
