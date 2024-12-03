package com.company.groomingzone.barbershop.repository.impl;

import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.company.groomingzone.barbershop.repository.BarberShopEntityJpaRepository;
import com.company.groomingzone.barbershop.repository.BarberShopEntityRepository;
import com.company.groomingzone.barbershop.repository.BarberShopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BarberShopEntityRepositoryImpl implements BarberShopEntityRepository {

    private final BarberShopEntityJpaRepository jpaRepository;
    private final BarberShopEntityCustomRepository customRepository;
    private final BarberShopMapper barberShopMapper;
}
