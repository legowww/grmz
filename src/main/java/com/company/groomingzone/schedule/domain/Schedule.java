package com.company.groomingzone.schedule.domain;


import java.time.OffsetDateTime;

public record Schedule(
        Long id,
        Long barberId,
        Long barberShopId,
        Long customerId,
        OffsetDateTime startTime,
        OffsetDateTime endTime,
        ScheduleStatus scheduleStatus
) {
}
