package com.company.groomingzone.reservation.controller;

import com.company.groomingzone.common.ApiResponse;
import com.company.groomingzone.common.CommonIdResponse;
import com.company.groomingzone.reservation.service.ReservationService;
import com.company.groomingzone.reservation.controller.request.ReservationCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RequiredArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * 예약 생성 API
     *
     * @param customerId 예약자, Access Token 대체
     * @param request 예약에 필요한 식별자 정보
     */
    @PostMapping("/reservations")
    public ResponseEntity<ApiResponse<CommonIdResponse>> reserve(Long customerId, @RequestBody ReservationCreateRequest request) {
        return ResponseEntity.ok(ApiResponse.success(CommonIdResponse.of(reservationService.reserve(1L, request.toReservationTarget()))));
    }



}
