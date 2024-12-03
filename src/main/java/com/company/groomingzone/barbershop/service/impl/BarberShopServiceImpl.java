package com.company.groomingzone.barbershop.service.impl;

import com.company.groomingzone.barbershop.dto.CreateBarberShopRequest;
import com.company.groomingzone.barbershop.dto.response.SingleBarberShopResponse;
import com.company.groomingzone.barbershop.repository.BarberShopEntityRepository;
import com.company.groomingzone.barbershop.service.BarberShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BarberShopServiceImpl implements BarberShopService {

    private final BarberShopEntityRepository repository;

    // TODO
    @Override
    @Transactional
    public SingleBarberShopResponse createBarberShop(CreateBarberShopRequest request, Long requestMemberId) {
        return null;
    }
}
