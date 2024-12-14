package com.company.groomingzone.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationEntityRepository extends JpaRepository<ReservationEntity, Long> {
}
