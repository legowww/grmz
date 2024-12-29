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
                Location.of(barberShopEntity.getLatitude(), barberShopEntity.getLongitude()),
                barberShopEntity.getIsActive());
    }

    public BarberShopEntity mapToDatabaseEntity(BarberShop barberShop) {
        return BarberShopEntity.builder()
            .id(barberShop.getId())
            .ownerId(barberShop.getOwner().id())
            .name(barberShop.getName().name())
            .address(barberShop.getAddress().address())
            .phone(barberShop.getPhoneNumber().phoneNumber())
            .introduction(barberShop.getIntroduction())
            .isActive(barberShop.isActive())
            .build();
    }
}
