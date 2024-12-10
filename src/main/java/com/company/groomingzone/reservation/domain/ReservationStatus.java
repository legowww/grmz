package com.company.groomingzone.reservation.domain;

public enum ReservationStatus {
    /**
     * 고객이 예약 신청한 상태
     */
    REQUESTED,

    /**
     * 바버가 예약을 승인한 상태
     */
    CONFIRMED,

    /**
     * 고객이 예약을 취소한 상태
     */
    CANCELED_BY_CUSTOMER,

    /**
     * 바버가 예약을 취소한 상태
     */
    CANCELED_BY_BARBER,

    /**
     * 노쇼 상태
     */
    NO_SHOW,

    /**
     * 시술이 완료된 상태
     */
    COMPLETED;
}
