package com.company.groomingzone.barber.controller.response;

import com.company.groomingzone.barber.domain.BarberInfo;
import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import lombok.Builder;

@Builder
public record BarberDetailResponse(
        Long id,
        Long barberShopId,
        String introduction,
        Boolean isActive,
        String name
) {

    public static BarberDetailResponse from(BarberInfoDto barberInfoDto) {
        return BarberDetailResponse.builder()
                .id(barberInfoDto.id())
                .barberShopId(barberInfoDto.barberShopId())
                .introduction(barberInfoDto.introduction())
                .isActive(barberInfoDto.isActive())
                .name(barberInfoDto.name())
                .build();
    }
}
