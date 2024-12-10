package com.company.groomingzone.reservation.repository;

import com.company.groomingzone.reservation.domain.Reservation;
import com.company.groomingzone.reservation.domain.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationJpaRepository implements ReservationRepository {

    private final ReservationEntityRepository reservationEntityRepository;
    private final ReservationMapper reservationMapper;


    @Override
    public Long save(Reservation reservation) {
        ReservationEntity entity = reservationEntityRepository.save(reservationMapper.mapToDatabaseEntity(reservation));
        return entity.getId();
    }
}
