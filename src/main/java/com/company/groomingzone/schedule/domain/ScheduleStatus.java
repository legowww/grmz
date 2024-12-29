package com.company.groomingzone.schedule.domain;

public enum ScheduleStatus {
    /**
     * 예약 가능한 상태
     */
    AVAILABLE,

    /**
     * 예약된 상태
     */
    RESERVED,

    /**
     * 예약 취소된 상태
     */
    CANCELED,

    /**
     * 바버 임의 마감
     */
    CLOSED;
}
