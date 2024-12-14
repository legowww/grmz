package com.company.groomingzone.schedule.repository;


import com.company.groomingzone.schedule.domain.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public Schedule mapToDomainEntity(ScheduleEntity scheduleEntity) {
        return null;
    }

    public ScheduleEntity mapToDatabaseEntity(Schedule schedule) {
        return new ScheduleEntity();
    }
}
