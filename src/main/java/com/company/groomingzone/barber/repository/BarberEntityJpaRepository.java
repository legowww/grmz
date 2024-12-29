package com.company.groomingzone.barber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface BarberEntityJpaRepository extends JpaRepository<BarberEntity, Long> {
}
