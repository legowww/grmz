package com.company.groomingzone.schedule.domain;

import org.springframework.stereotype.Component;

@Component
public class ScheduleValidator {

    public void validateScheduleAvailability(Schedule schedule) {
        if (schedule.scheduleStatus().equals(ScheduleStatus.RESERVED)) {
            throw new IllegalStateException("이미 예약이 마감된 시간대입니다.");
        }
    }
}
