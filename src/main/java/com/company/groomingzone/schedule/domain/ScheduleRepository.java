package com.company.groomingzone.schedule.domain;

public interface ScheduleRepository {

    Schedule findById(Long scheduleId);

    Long save(Schedule schedule);
}
