package com.company.groomingzone.barber.controller.response;

import com.company.groomingzone.barber.domain.BarberInfo;
import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import lombok.Builder;

@Builder
public record BarberListResponse(
        Long id,
        Long barberShopId,
        String name
) {

    public static BarberListResponse from(BarberInfoDto barberInfoDto) {
        return BarberListResponse.builder()
                .id(barberInfoDto.id())
                .barberShopId(barberInfoDto.barberShopId())
                .name(barberInfoDto.name())
                .build();
    }
}
