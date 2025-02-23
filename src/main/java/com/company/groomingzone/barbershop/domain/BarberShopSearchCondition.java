package com.company.groomingzone.barbershop.domain;

import com.company.groomingzone.common.repository.SearchCondition;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public class BarberShopSearchCondition extends SearchCondition {

    private String keyword;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Double distance;
}
