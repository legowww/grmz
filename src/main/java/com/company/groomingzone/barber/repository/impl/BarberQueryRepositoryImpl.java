package com.company.groomingzone.barber.repository.impl;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.domain.BarberInfo;
import com.company.groomingzone.barber.service.BarberQueryRepository;
import com.company.groomingzone.barber.service.dto.BarberInfoDto;
import com.company.groomingzone.barber.service.dto.BarberSearchCondition;
import com.company.groomingzone.common.repository.SingleSortCondition;
import com.company.groomingzone.common.repository.ListQueryResponse;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.company.groomingzone.barber.repository.QBarberEntity.barberEntity;
import static com.company.groomingzone.member.QMemberEntity.memberEntity;

@Repository
@RequiredArgsConstructor
public class BarberQueryRepositoryImpl implements BarberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public BarberInfoDto readBarber(Long barberId) {
        BarberInfoDto result = jpaQueryFactory
                .select(Projections.constructor(
                        BarberInfoDto.class,
                        barberEntity.id,
                        barberEntity.barberShopId,
                        barberEntity.introduction,
                        barberEntity.isActive,
                        memberEntity.name
                ))
                .from(barberEntity)
                .innerJoin(memberEntity)
                .on(barberEntity.id.eq(memberEntity.id))
                .where(
                        barberEntity.id.eq(barberId),
                        barberEntity.isActive.eq(true)
                )
                .fetchOne();

        if (result == null) {
            throw new EntityNotFoundException("바버를 찾을 수 없습니다: " + barberId);
        }

        return result;

    }

    @Override
    public ListQueryResponse<BarberInfoDto> readBarberList(BarberSearchCondition condition) {
        List<BarberInfoDto> content = jpaQueryFactory.
                select(Projections.constructor(
                        BarberInfoDto.class,
                        barberEntity.id,
                        barberEntity.barberShopId,
                        barberEntity.introduction,
                        barberEntity.isActive,
                        memberEntity.name
                ))
                .from(barberEntity)
                .innerJoin(memberEntity)
                .on(barberEntity.id.eq(memberEntity.id))
                .where(
                        hasBarberShopId(condition.getBarberShopId()),
                        barberEntity.isActive.eq(true)
                )
                .offset(condition.getOffset())
                .limit(condition.getScrollLimit())
                .orderBy(getOrder(condition.getSortCondition()))
                .fetch();

        return ListQueryResponse.createScrollResponse(content, condition);
    }

    private OrderSpecifier<?> getOrder(SingleSortCondition sortCondition) {
        if (sortCondition == null ||sortCondition.sortBy() == null || sortCondition.direction() == null) {
            return new OrderSpecifier<>(Order.DESC, barberEntity.createdTs);
        }

        // TODO: 정렬 조건 추가 예정
        return new OrderSpecifier<>(Order.DESC, barberEntity.createdTs);
    }

    private BooleanExpression hasBarberShopId(Long barberShopId) {
        return barberShopId != null ? barberEntity.barberShopId.eq(barberShopId) : null;
    }
 }
