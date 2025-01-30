package com.company.groomingzone.barber.controller;

import com.company.groomingzone.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/barbers")
public class BarberController {

    @GetMapping
    public ApiResponse<?> findBarberShopList() {
        return null;
    }
}
