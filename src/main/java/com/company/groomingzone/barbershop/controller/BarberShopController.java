package com.company.groomingzone.barbershop.controller;

import com.company.groomingzone.barbershop.dto.CreateBarberShopRequest;
import com.company.groomingzone.barbershop.service.BarberShopService;
import com.company.groomingzone.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/barber-shop")
public class BarberShopController {

    private final BarberShopService barberShopService;

    //TODO Spring Security 적용해서 id 받아와서 넣어줘야함. 아니? 자기 바버샵 아닐 수도 있잖아.
    // 아니? 근데 등록자 != 원장이면 원장한테 알림 보내주면 좋을 듯
    @PostMapping
    public ApiResponse<?> createBarberShop(CreateBarberShopRequest request) {
        Long requestMemberId = 123L; // TODO 나중에 Security로 ㄱㄱ
        return ApiResponse.success(barberShopService.createBarberShop(request, requestMemberId));
    }
}
