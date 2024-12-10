package com.company.groomingzone.barbershopschedule.controller.request;

import com.company.groomingzone.barbershopschedule.domain.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public record CreateScheduleRequest(
        Long barberId,
        Long barberShopId,
        OffsetDateTime startDateTime,
        OffsetDateTime endDateTime,
        TimeInterval interval,
        List<LocalDate> excludeDates,         // 제외할 특정 날짜
        List<ExcludeTimeRange> excludeTimeRanges,  // 제외할 시간대 (예: 매일 점심시간)
        List<DayOfWeek> excludeDayOfWeeks     // 제외할 요일
) {

    public record ExcludeDateTime(
            LocalDate dateTime
    ) {}

    public record ExcludeTimeRange(
            LocalTime startTime,
            LocalTime endTime
    ) {}
}
