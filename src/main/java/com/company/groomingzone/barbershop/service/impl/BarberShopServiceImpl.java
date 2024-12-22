package com.company.groomingzone.barbershop.service.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.service.BarberService;
import com.company.groomingzone.barbershop.domain.Address;
import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.domain.Location;
import com.company.groomingzone.barbershop.domain.Name;
import com.company.groomingzone.barbershop.domain.PhoneNumber;
import com.company.groomingzone.barbershop.repository.BarberShopRepository;
import com.company.groomingzone.barbershop.service.BarberShopService;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BarberShopServiceImpl implements BarberShopService {

    private final BarberShopRepository repository;
    private final BarberService barberService;

    // TODO
    @Override
    @Transactional
    public BarberShop createBarberShop(CreateBarberShopCommand command, Long requestMemberId) {
        Barber requestBarber = barberService.readBarberById(requestMemberId);
        Barber owner = barberService.readBarberById(command.ownerId());
        if (!requestBarber.equals(owner)) {
            // 어쩌구 저쩌구 알림 보냄
        }
        BarberShop barberShop = BarberShop.withOutId(owner,
            Name.of(command.name()),
            Address.of(command.address()),
            PhoneNumber.of(command.phone()),
            command.introduction(),
            Location.of(command.latitude(), command.longitude()),
            true);
        return repository.save(barberShop);
    }
}
