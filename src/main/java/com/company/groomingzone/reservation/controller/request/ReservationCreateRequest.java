package com.company.groomingzone.reservation.controller.request;

import com.company.groomingzone.reservation.domain.ReservationTarget;

public record ReservationCreateRequest(
        Long barberShopId,
        Long barberShopScheduleId,
        Long barberShopStyleId
) {

    public ReservationTarget toReservationTarget() {
        return new ReservationTarget(barberShopId, barberShopScheduleId, barberShopStyleId);
    }
}
