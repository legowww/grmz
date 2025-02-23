package com.company.groomingzone.barber.service.dto;

import com.company.groomingzone.common.repository.SearchCondition;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BarberSearchCondition extends SearchCondition {

    private Long barberShopId;
}
