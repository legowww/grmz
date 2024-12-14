package com.company.groomingzone.reservation.domain;

public record ReservationTarget(
        Long barberShopId,
        Long scheduleId,
        Long styleId
) {
}
