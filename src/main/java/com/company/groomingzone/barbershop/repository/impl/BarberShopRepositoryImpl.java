package com.company.groomingzone.barbershop.repository.impl;

import com.company.groomingzone.barbershop.domain.BarberShop;
import com.company.groomingzone.barbershop.repository.BarberShopEntity;
import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.company.groomingzone.barbershop.repository.BarberShopEntityJpaRepository;
import com.company.groomingzone.barbershop.repository.BarberShopMapper;
import com.company.groomingzone.barbershop.repository.BarberShopRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BarberShopRepositoryImpl implements BarberShopRepository {

    private final BarberShopEntityJpaRepository jpaRepository;
    private final BarberShopEntityCustomRepository customRepository;
    private final BarberShopMapper barberShopMapper;

    @Override
    public BarberShop findById(Long id) {
        BarberShopEntity barberShopEntity = jpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 스케줄입니다."));

        return barberShopMapper.mapToDomainEntity(barberShopEntity);
    }

    @Override
    public BarberShop saveBarberShop(BarberShop barberShop) {
        BarberShopEntity dbEntity = barberShopMapper.mapToDatabaseEntity(barberShop);
        BarberShopEntity savedDbEntity = jpaRepository.save(dbEntity);
        return barberShopMapper.mapToDomainEntity(savedDbEntity);
    }
}
