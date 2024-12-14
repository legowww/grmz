package com.company.groomingzone.reservation.controller.request;

import com.company.groomingzone.reservation.domain.ReservationTarget;

public record ReservationCreateRequest(
        Long barberShopId,
        Long scheduleId,
        Long styleId
) {

    public ReservationTarget toReservationTarget() {
        return new ReservationTarget(barberShopId, scheduleId, styleId);
    }
}
