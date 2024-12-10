package com.company.groomingzone.barbershopschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberShopScheduleEntityRepository extends JpaRepository<BarberShopScheduleEntity, Long> {

}
