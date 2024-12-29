package com.company.groomingzone.schedule.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor(staticName = "of")
@Getter
public class Schedule {

    private Long id;
    private Long barberId;
    private Long barberShopId;
    private Long customerId;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private ScheduleStatus scheduleStatus;

    public void reserve(Long customerId) {
        this.customerId = customerId;
        this.scheduleStatus = ScheduleStatus.RESERVED;
    }
}
