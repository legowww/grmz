package com.company.groomingzone.style.repository;

import com.company.groomingzone.style.domain.Style;
import org.springframework.stereotype.Component;

@Component
public class StyleMapper {

    public Style mapToDomainEntity(StyleEntity styleEntity) {
        return Style.of(
                styleEntity.getId(),
                styleEntity.getBarberShopId(),
                styleEntity.getBarberId(),
                styleEntity.getName(),
                styleEntity.getPrice(),
                styleEntity.getDescription(),
                styleEntity.getUrl(),
                styleEntity.getStyleCategory()
        );
    }

    public StyleEntity mapToDatabaseEntity(Style style) {
        return null;
    }
}
