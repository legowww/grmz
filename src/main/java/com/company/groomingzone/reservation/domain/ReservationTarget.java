package com.company.groomingzone.reservation.domain;

public record ReservationTarget(
        Long barberShopId,
        Long barberShopScheduleId,
        Long barberShopStyleId
) {
}
