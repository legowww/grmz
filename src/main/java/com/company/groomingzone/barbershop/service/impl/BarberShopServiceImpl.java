package com.company.groomingzone.barbershop.service.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.service.BarberService;
import com.company.groomingzone.barbershop.domain.*;
import com.company.groomingzone.barbershop.domain.BarberShopInfo;
import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.company.groomingzone.barbershop.repository.BarberShopRepository;
import com.company.groomingzone.barbershop.service.BarberShopService;
import com.company.groomingzone.barbershop.service.dto.CreateBarberShopCommand;
import com.company.groomingzone.common.repository.ListQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BarberShopServiceImpl implements BarberShopService {

    private final BarberShopRepository repository;
    private final BarberShopEntityCustomRepository barberShopEntityCustomRepository;
    private final BarberService barberService;

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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ListQueryResponse<BarberShopInfo> readBarberShopList(BarberShopSearchCondition condition) {
        return barberShopEntityCustomRepository.findBarberShopList(condition);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BarberShop readBarberShop(Long id) {
        // TODO: 평점 + 카운트
        return repository.findById(id);
    }
}
