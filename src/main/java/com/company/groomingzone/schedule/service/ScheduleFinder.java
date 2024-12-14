package com.company.groomingzone.schedule.service;

import com.company.groomingzone.schedule.domain.Schedule;
import com.company.groomingzone.schedule.domain.ScheduleRepository;
import com.company.groomingzone.schedule.domain.ScheduleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ScheduleFinder {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleValidator scheduleValidator;


    @Transactional(readOnly = true)
    public Schedule findById(Long barberShopScheduledId) {
        return scheduleRepository.findById(barberShopScheduledId);
    }


    @Transactional(readOnly = true)
    public Schedule findAvailabilitySchedule(Long scheduledId) {
        Schedule schedule = findById(scheduledId);
        scheduleValidator.validateScheduleAvailability(schedule);

        return schedule;
    }
}

