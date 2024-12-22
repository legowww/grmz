package com.company.groomingzone.reservation.controller;

import com.company.groomingzone.common.ApiResponse;
import com.company.groomingzone.common.CommonIdResponse;
import com.company.groomingzone.reservation.service.ReservationService;
import com.company.groomingzone.reservation.controller.request.ReservationCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RequiredArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;


    @PostMapping("/reservations")
    public ResponseEntity<ApiResponse<CommonIdResponse>> save(Long customerId, ReservationCreateRequest request) {
        return ResponseEntity.ok(ApiResponse.success(CommonIdResponse.of(reservationService.save(customerId, request.toReservationTarget()))));
    }
}
