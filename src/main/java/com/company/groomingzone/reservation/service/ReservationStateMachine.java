package com.company.groomingzone.reservation.service;

import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
public class ReservationStateMachine {

    private final ReservationRepository reservationRepository;


    public Long request(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
