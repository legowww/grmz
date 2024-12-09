package com.company.groomingzone.barber.repository.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.repository.BarberEntity;
import com.company.groomingzone.barber.repository.BarberEntityJpaRepository;
import com.company.groomingzone.barber.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BarberRepositoryImpl implements BarberRepository {

    private final BarberEntityJpaRepository jpaRepository;
    private final BarberMapper mapper;

    @Override
    public Barber findById(long id) {
        BarberEntity barberEntity = jpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("barber not found"));
        return mapper.mapToDomainEntity(barberEntity);
    }
}
