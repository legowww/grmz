package com.company.groomingzone.barbershopschedule.infra;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BarberShopScheduleQueryRepository {

    private final JPAQueryFactory queryFactory;

    /*
        TODO: 메서드 제거 예정 (queryDSL 테스트용)
     */

    // 특정 날짜 범위의 스케줄 조회
    public List<BarberShopScheduleEntity> findSchedulesInDateRange(OffsetDateTime startDate, OffsetDateTime endDate) {
        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        return queryFactory
                .selectFrom(schedule)
                .where(schedule.dateTime.between(startDate, endDate))
                .orderBy(schedule.dateTime.asc())
                .fetch();
    }

    // 특정 바버숍의 해당 날짜 이후의 모든 스케줄
    public List<BarberShopScheduleEntity> findFutureSchedulesByBarberShop(Long barberShopId, OffsetDateTime fromDate) {
        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        return queryFactory
                .selectFrom(schedule)
                .where(
                        schedule.barberShopId.eq(barberShopId),
                        schedule.dateTime.goe(fromDate)
                )
                .orderBy(schedule.dateTime.asc())
                .fetch();
    }

    // 여러 바버의 스케줄을 한번에 조회
    public List<BarberShopScheduleEntity> findSchedulesByBarberIds(List<Long> barberIds, OffsetDateTime fromDate) {
        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        return queryFactory
                .selectFrom(schedule)
                .where(
                        schedule.barberId.in(barberIds),
                        schedule.dateTime.goe(fromDate)
                )
                .orderBy(schedule.dateTime.asc())
                .fetch();
    }

    // 특정 시간대의 스케줄 조회 (예: 오전 9시~12시 사이)
    public List<BarberShopScheduleEntity> findSchedulesInTimeRange(OffsetDateTime baseDate, int startHour, int endHour) {
        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        OffsetDateTime startDateTime = baseDate.withHour(startHour).withMinute(0);
        OffsetDateTime endDateTime = baseDate.withHour(endHour).withMinute(0);

        return queryFactory
                .selectFrom(schedule)
                .where(schedule.dateTime.between(startDateTime, endDateTime))
                .orderBy(schedule.dateTime.asc())
                .fetch();
    }

    // 페이징 처리된 스케줄 조회
    public Page<BarberShopScheduleEntity> findSchedulesWithPaging(Long barberShopId, Pageable pageable) {
        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        List<BarberShopScheduleEntity> schedules = queryFactory
                .selectFrom(schedule)
                .where(schedule.barberShopId.eq(barberShopId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(schedule.dateTime.desc())
                .fetch();

        // 전체 카운트 조회
        long total = queryFactory
                .select(schedule.count())
                .from(schedule)
                .where(schedule.barberShopId.eq(barberShopId))
                .fetchOne();

        return new PageImpl<>(schedules, pageable, total);
    }

    // 동적 쿼리 예시
    public List<BarberShopScheduleEntity> findSchedulesByDynamicConditions(
            Long barberId,
            Long barberShopId,
            OffsetDateTime startDate,
            OffsetDateTime endDate) {

        QBarberShopScheduleEntity schedule = QBarberShopScheduleEntity.barberShopScheduleEntity;

        return queryFactory
                .selectFrom(schedule)
                .where(
                        barberIdEq(barberId),
                        barberShopIdEq(barberShopId),
                        dateTimeBetween(startDate, endDate)
                )
                .orderBy(schedule.dateTime.asc())
                .fetch();
    }

    // 동적 쿼리를 위한 조건 메서드들
    private BooleanExpression barberIdEq(Long barberId) {
        return barberId != null ? QBarberShopScheduleEntity.barberShopScheduleEntity.barberId.eq(barberId) : null;
    }

    private BooleanExpression barberShopIdEq(Long barberShopId) {
        return barberShopId != null ? QBarberShopScheduleEntity.barberShopScheduleEntity.barberShopId.eq(barberShopId) : null;
    }

    private BooleanExpression dateTimeBetween(OffsetDateTime startDate, OffsetDateTime endDate) {
        if (startDate == null || endDate == null) return null;
        return QBarberShopScheduleEntity.barberShopScheduleEntity.dateTime.between(startDate, endDate);
    }
}
