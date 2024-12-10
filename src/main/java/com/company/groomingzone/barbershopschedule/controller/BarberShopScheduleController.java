package com.company.groomingzone.barbershopschedule.controller;


import com.company.groomingzone.barbershopschedule.service.BarberShopScheduleService;
import com.company.groomingzone.barbershopschedule.controller.request.CreateScheduleRequest;
import com.company.groomingzone.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BarberShopScheduleController {

    private final BarberShopScheduleService barberShopScheduleService;


    /**
     *
     * @param request
     * {
     *     "barberId": 654,
     *     "barberShopId": 22,
     *     "startDateTime": "2024-12-01T10:00:00.000+09:00",
     *     "endDateTime": "2024-12-31T18:00:00.000+09:00",
     *     "interval": "THIRTY_MINUTES",
     *     "excludeDates": [
     *         "2024-12-25",  // 크리스마스
     *         "2024-12-31"   // 연말
     *     ],
     *     "excludeTimeRanges": [
     *         {"startTime": "12:00", "endTime": "13:00"}  // 점심시간
     *     ],
     *     "excludeDayOfWeeks": ["MONDAY"]  // 매주 월요일 휴무
     * }
     */
    public ResponseEntity<ApiResponse<?>> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.ok(ApiResponse.success(""));
    }
}
