package com.company.groomingzone.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleEntityRepository extends JpaRepository<ScheduleEntity, Long> {

}
