package com.company.groomingzone.reservation.service;

import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ReservationWriter {

    private final ReservationRepository reservationRepository;


    @Transactional
    public Long save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
