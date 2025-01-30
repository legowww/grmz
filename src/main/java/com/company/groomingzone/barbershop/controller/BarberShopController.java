package com.company.groomingzone.barbershop.controller;

import com.company.groomingzone.barbershop.controller.dto.PostBarberShopRequest;
import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.dto.response.BarberShopDetailResponse;
import com.company.groomingzone.barbershop.dto.response.BarberShopListResponse;
import com.company.groomingzone.barbershop.service.BarberShopService;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import com.company.groomingzone.common.ApiResponse;
import com.company.groomingzone.common.repository.SingleSortCondition;
import com.company.groomingzone.common.repository.querydsl.ScrollResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/barber-shops")
public class BarberShopController {

    private final BarberShopService barberShopService;

    //TODO Spring Security 적용해서 id 받아와서 넣어줘야함. 아니? 자기 바버샵 아닐 수도 있잖아.
    // 아니? 근데 등록자 != 원장이면 원장한테 알림 보내주면 좋을 듯
    @PostMapping
    public ApiResponse<?> createBarberShop(PostBarberShopRequest request) {
        Long requestMemberId = 123L; // TODO 나중에 Security로 ㄱㄱ
        CreateBarberShopCommand command = CreateBarberShopCommand.of(request.ownerId(),
                request.name(),
                request.address(),
                request.phone(),
                request.introduction(),
                request.latitude(),
                request.longitude());
        return ApiResponse.success(barberShopService.createBarberShop(command, requestMemberId));
    }


    @GetMapping
    public ApiResponse<ScrollResponse<BarberShopListResponse>> findBarberShopList(
            @RequestParam(required = false) String keyword,            // 매장명
            @RequestParam(required = false) BigDecimal latitude,       // 현재 위치 위도
            @RequestParam(required = false) BigDecimal longitude,      // 현재 위치 경도
            @RequestParam(required = false) Double distance,           // 검색 반경(km)
            @RequestParam(required = false, defaultValue = "created_ts") String sortBy,
            @RequestParam(required = false, defaultValue = "desc") String direction,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "20") int limit
    ) {
        BarberShopSearchCondition condition = BarberShopSearchCondition.builder()
                .keyword(keyword)
                .latitude(latitude)
                .longitude(longitude)
                .distance(distance)
                .offset(offset)
                .limit(limit)
                .sortCondition(new SingleSortCondition(sortBy, direction))
                .build();

        return ApiResponse.success(barberShopService.readBarberShopList(condition));
    }


    @GetMapping("/{id}")
    public ApiResponse<BarberShopDetailResponse> findBarberShop(
            @PathVariable Long id
    ) {
        return ApiResponse.success(barberShopService.findById(id));
    }
}
