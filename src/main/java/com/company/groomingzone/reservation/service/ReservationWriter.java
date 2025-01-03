package com.company.groomingzone.reservation.service;

import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationRepository;
import com.company.groomingzone.schedule.domain.Schedule;
import com.company.groomingzone.schedule.domain.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ReservationWriter {

    private final ReservationRepository reservationRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Long reserve(Reservation reservation, Schedule schedule) {
        scheduleRepository.save(schedule);
        return reservationRepository.save(reservation);
    }
}
