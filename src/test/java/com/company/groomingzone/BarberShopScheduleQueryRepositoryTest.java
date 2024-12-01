package com.company.groomingzone;

import com.company.groomingzone.barbershopschedule.infra.BarberShopScheduleEntity;
import com.company.groomingzone.barbershopschedule.infra.BarberShopScheduleEntityRepository;
import com.company.groomingzone.barbershopschedule.infra.BarberShopScheduleQueryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class BarberShopScheduleQueryRepositoryTest {

    @Autowired
    private BarberShopScheduleQueryRepository queryRepository;

    @Autowired
    private BarberShopScheduleEntityRepository jpaRepository; // 테스트 데이터 생성용

    @BeforeEach
    void setUp() {
        // 테스트 데이터 생성
        List<BarberShopScheduleEntity> schedules = Arrays.asList(
                new BarberShopScheduleEntity(1L, 1L, OffsetDateTime.now()),
                new BarberShopScheduleEntity(1L, 1L, OffsetDateTime.now().plusHours(1)),
                new BarberShopScheduleEntity(2L, 1L, OffsetDateTime.now().plusHours(2)),
                new BarberShopScheduleEntity(2L, 2L, OffsetDateTime.now().plusDays(1))
        );

        jpaRepository.saveAll(schedules);
    }

    @AfterEach
    void cleanup() {
        jpaRepository.deleteAll();
    }

    @Test
    void findSchedulesInDateRange() {
        // given
        OffsetDateTime startDate = OffsetDateTime.now().minusHours(1);
        OffsetDateTime endDate = OffsetDateTime.now().plusHours(3);

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findSchedulesInDateRange(startDate, endDate);

        // then
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getDateTime()).isBefore(result.get(1).getDateTime());
    }

    @Test
    void findFutureSchedulesByBarberShop() {
        // given
        Long barberShopId = 1L;
        OffsetDateTime fromDate = OffsetDateTime.now().minusHours(1);

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findFutureSchedulesByBarberShop(barberShopId, fromDate);

        // then
        assertThat(result).hasSize(3);
        assertThat(result).allMatch(schedule -> schedule.getBarberShopId().equals(barberShopId));
    }

    @Test
    void findSchedulesByBarberIds() {
        // given
        List<Long> barberIds = Arrays.asList(1L, 2L);
        OffsetDateTime fromDate = OffsetDateTime.now().minusHours(1);

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findSchedulesByBarberIds(barberIds, fromDate);

        // then
        assertThat(result).hasSize(4);
        assertThat(result).allMatch(schedule -> barberIds.contains(schedule.getBarberId()));
    }

    @Test
    void findSchedulesInTimeRange() {
        // given
        OffsetDateTime baseDate = OffsetDateTime.now();
        int startHour = baseDate.getHour();
        int endHour = baseDate.getHour() + 2;

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findSchedulesInTimeRange(baseDate, startHour, endHour);

        // then
        assertThat(result).hasSize(3);
        assertThat(result).allMatch(schedule ->
                schedule.getDateTime().getHour() >= startHour &&
                        schedule.getDateTime().getHour() <= endHour
        );
    }

    @Test
    void findSchedulesWithPaging() {
        // given
        Long barberShopId = 1L;
        Pageable pageable = PageRequest.of(0, 2);

        // when
        Page<BarberShopScheduleEntity> result = queryRepository.findSchedulesWithPaging(barberShopId, pageable);

        // then
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getTotalElements()).isEqualTo(3);
    }

    @Test
    void findSchedulesByDynamicConditions() {
        // given
        Long barberId = 1L;
        Long barberShopId = 1L;
        OffsetDateTime startDate = OffsetDateTime.now().minusHours(1);
        OffsetDateTime endDate = OffsetDateTime.now().plusHours(2);

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findSchedulesByDynamicConditions(
                barberId, barberShopId, startDate, endDate);

        // then
        assertThat(result).hasSize(2);
        assertThat(result).allMatch(schedule ->
                schedule.getBarberId().equals(barberId) &&
                        schedule.getBarberShopId().equals(barberShopId)
        );
    }

    @Test
    void findSchedulesByDynamicConditions_WithNullParameters() {
        // given
        Long barberId = null;
        Long barberShopId = 1L;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;

        // when
        List<BarberShopScheduleEntity> result = queryRepository.findSchedulesByDynamicConditions(
                barberId, barberShopId, startDate, endDate);

        // then
        assertThat(result).hasSize(3);
        assertThat(result).allMatch(schedule ->
                schedule.getBarberShopId().equals(barberShopId)
        );
    }
}
