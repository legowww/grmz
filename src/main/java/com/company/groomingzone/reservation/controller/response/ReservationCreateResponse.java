package com.company.groomingzone.reservation.controller.response;


public record ReservationCreateResponse(Long reservationId) {

    public static ReservationCreateResponse of(Long reservationId) {
        return new ReservationCreateResponse(reservationId);
    }
}
