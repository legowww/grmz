package com.company.groomingzone.schedule.repository;


import com.company.groomingzone.schedule.domain.Schedule;
import com.company.groomingzone.schedule.domain.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ScheduleJpaRepository implements ScheduleRepository {

    private final ScheduleEntityRepository scheduleEntityRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public Schedule findById(Long barberShopScheduledId) {
        ScheduleEntity scheduleEntity = scheduleEntityRepository.findById(barberShopScheduledId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 스케줄입니다."));

        return scheduleMapper.mapToDomainEntity(scheduleEntity);
    }

    @Override
    public Long save(Schedule schedule) {
        return scheduleEntityRepository.save(scheduleMapper.mapToDatabaseEntity(schedule)).getId();
    }
}
