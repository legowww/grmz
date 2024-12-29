package com.company.groomingzone.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface ScheduleEntityRepository extends JpaRepository<ScheduleEntity, Long> {

}
