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

    public Long reserve(Long customerId, ReservationTarget reservationTarget) {
        BarberShop barberShop = barberShopFinder.findById(reservationTarget.barberShopId());
        Style style = styleFinder.findById(reservationTarget.styleId());
        Schedule schedule = scheduleFinder.findAvailabilitySchedule(reservationTarget.scheduleId());
        schedule.reserve(customerId);
        Reservation reservation = Reservation.of(customerId, barberShop, schedule, style);

        return reservationWriter.reserve(reservation, schedule);
    }
}
