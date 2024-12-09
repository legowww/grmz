package com.company.groomingzone.barbershop.repository;

import com.company.groomingzone.barber.repository.BarberRepository;
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

    private final BarberRepository barberRepository;

    public BarberShop mapToDomainEntity(BarberShopEntity barberShopEntity) {
        return BarberShop.of(barberRepository.findById(barberShopEntity.getOwnerId()),
            Name.of(barberShopEntity.getName()),
            Address.of(barberShopEntity.getAddress()),
            PhoneNumber.of(barberShopEntity.getPhone()),
            barberShopEntity.getIntroduction(),
            Location.of(barberShopEntity.getLatitude().doubleValue(), barberShopEntity.getLongitude().doubleValue()));
    }

    public BarberShopEntity mapToDatabaseEntity(BarberShop barberShop) {
        return new BarberShopEntity();
    }
}
