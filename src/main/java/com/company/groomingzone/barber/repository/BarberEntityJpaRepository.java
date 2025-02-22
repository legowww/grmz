package com.company.groomingzone.barber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberEntityJpaRepository extends JpaRepository<BarberEntity, Long> {



}
