package com.company.groomingzone.barbershopschedule.repository;


import com.company.groomingzone.barbershopschedule.domain.BarberShopSchedule;
import com.company.groomingzone.barbershopschedule.domain.BarberShopScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BarberShopScheduleJpaRepository implements BarberShopScheduleRepository {

    private final BarberShopScheduleEntityRepository barberShopScheduleJpaRepository;
    private final BarberShopScheduleMapper barberShopScheduleMapper;


    @Override
    public BarberShopSchedule findById(Long barberShopScheduledId) {
        BarberShopScheduleEntity barberShopScheduleEntity = barberShopScheduleJpaRepository.findById(barberShopScheduledId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 스케줄입니다."));

        return barberShopScheduleMapper.mapToDomainEntity(barberShopScheduleEntity);
    }
}
