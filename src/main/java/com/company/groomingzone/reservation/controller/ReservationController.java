package com.company.groomingzone.reservation.controller;

import com.company.groomingzone.common.ApiResponse;
import com.company.groomingzone.reservation.controller.response.ReservationCreateResponse;
import com.company.groomingzone.reservation.service.ReservationService;
import com.company.groomingzone.reservation.controller.request.ReservationCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/reservations")
@RequiredArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;


    @PostMapping
    public ResponseEntity<ApiResponse<ReservationCreateResponse>> reservationRequest(Long customerId, ReservationCreateRequest request) {
        return ResponseEntity.ok(ApiResponse.success(ReservationCreateResponse.of(reservationService.requestReservation(customerId, request.toReservationTarget()))));
    }
}
