package com.company.groomingzone.schedule.repository;


import com.company.groomingzone.schedule.domain.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public Schedule mapToDomainEntity(ScheduleEntity scheduleEntity) {
        return Schedule.of(
                scheduleEntity.getId(),
                scheduleEntity.getBarberId(),
                scheduleEntity.getBarberShopId(),
                scheduleEntity.getCustomerId(),
                scheduleEntity.getStartTime(),
                scheduleEntity.getEndTime(),
                scheduleEntity.getScheduleStatus()
        );
    }

    public ScheduleEntity mapToDatabaseEntity(Schedule schedule) {
        return ScheduleEntity.of(
                schedule.getId(),
                schedule.getBarberId(),
                schedule.getBarberShopId(),
                schedule.getCustomerId(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getScheduleStatus()
        );
    }
}
