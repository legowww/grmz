package com.company.groomingzone.style.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;


@AllArgsConstructor(staticName = "of")
@Getter
public class Style {

    private Long id;
    private Long barberShopId;
    private Long barberId;
    private String name;
    private BigDecimal price;
    private String description;
    private String url;
    private StyleCategory styleCategory;
}
