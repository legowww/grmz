package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barbershop.domain.Address;
import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.domain.Location;
import com.company.groomingzone.barbershop.domain.Name;
import com.company.groomingzone.barbershop.domain.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BarberShopMapper {

    public BarberShop mapToDomainEntity(BarberShopEntity barberShopEntity, Barber owner) {
        return BarberShop.of(barberShopEntity.getId(),
                owner,
                Name.of(barberShopEntity.getName()),
                Address.of(barberShopEntity.getAddress()),
                PhoneNumber.of(barberShopEntity.getPhone()),
                barberShopEntity.getIntroduction(),
                Location.of(barberShopEntity.getLatitude().doubleValue(), barberShopEntity.getLongitude().doubleValue()),
                barberShopEntity.getIsActive());
    }

    public BarberShopEntity mapToDatabaseEntity(BarberShop barberShop) {
        return BarberShopEntity.builder()
            .id(barberShop.id())
            .ownerId(barberShop.owner().id())
            .name(barberShop.name().name())
            .address(barberShop.address().address())
            .phone(barberShop.phoneNumber().phoneNumber())
            .introduction(barberShop.introduction())
            .isActive(barberShop.isActive())
            .build();
    }
}
