package com.company.groomingzone.barber.controller;

import com.company.groomingzone.barber.controller.response.BarberDetailResponse;
import com.company.groomingzone.barber.controller.response.BarberListResponse;
import com.company.groomingzone.barber.domain.BarberInfo;
import com.company.groomingzone.barber.service.BarberService;
import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import com.company.groomingzone.barber.service.dto.BarberSearchCondition;
import com.company.groomingzone.common.ApiResponse;
import com.company.groomingzone.common.controller.dto.ListResponse;
import com.company.groomingzone.common.controller.dto.ScrollResponse;
import com.company.groomingzone.common.repository.SingleSortCondition;
import com.company.groomingzone.common.repository.ListQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/barbers")
public class BarberController {

    private final BarberService barberService;

    @GetMapping
    public ApiResponse<ListResponse<BarberListResponse>> readBarberList(
            @RequestParam(required = false) Long barberShopId,
            @RequestParam(required = false, defaultValue = "created_ts") String sortBy,
            @RequestParam(required = false, defaultValue = "desc") String direction,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "20") int limit
    ) {
        ListQueryResponse<BarberInfoDto> result = barberService.readBarberInfoList(BarberSearchCondition.builder()
                .barberShopId(barberShopId)
                .offset(offset)
                .limit(limit)
                .sortCondition(new SingleSortCondition(sortBy, direction))
                .build());

        ListResponse<BarberListResponse> response =
                ListResponse.ofScroll(
                        result.content().stream().map(BarberListResponse::from).toList(),
                        new ScrollResponse(result.pageNumber(), result.pageSize(), result.hasNext())
                );

        return ApiResponse.success(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<BarberDetailResponse> readBarber(@PathVariable long id) {
        return ApiResponse.success(BarberDetailResponse.from(barberService.readBarberInfo(id)));
    }
}
