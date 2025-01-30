package com.company.groomingzone.barbershop.repository.impl;

import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.dto.response.BarberShopListResponse;
import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.company.groomingzone.common.repository.SingleSortCondition;
import com.company.groomingzone.common.repository.querydsl.SliceUtility;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.company.groomingzone.barbershop.repository.QBarberShopEntity.barberShopEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class BarberShopEntityCustomRepositoryImpl implements BarberShopEntityCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public SliceImpl<BarberShopListResponse> findBarberShopList(BarberShopSearchCondition condition) {
        Pageable pageable = PageRequest.of(condition.getOffset(), condition.getLimit());

        List<BarberShopListResponse> content = jpaQueryFactory
                .select(Projections.constructor(BarberShopListResponse.class,
                        barberShopEntity.id,
                        barberShopEntity.name,
                        barberShopEntity.name // TODO: 목록 조회에 응답 데이터 미정
                ))
                .from(barberShopEntity)
                // TODO: 리뷰, 이미지 테이블 조인?
                .where(
                        barberShopEntity.isActive.eq(true),
                        nameContains(condition.getKeyword()),
                        inDistance(condition.getLatitude(), condition.getLongitude(), condition.getDistance())
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .orderBy(getOrder(condition.getSortCondition()))
                .fetch();

        return SliceUtility.execute(pageable, content);
    }


    private OrderSpecifier<?> getOrder(SingleSortCondition sortCondition) {
        if (sortCondition == null ||sortCondition.sortBy() == null || sortCondition.direction() == null) {
            return new OrderSpecifier<>(Order.DESC, barberShopEntity.createdTs);
        }

        // TODO: 정렬 조건 추가 예정
        return new OrderSpecifier<>(Order.DESC, barberShopEntity.createdTs);
    }


    private BooleanExpression nameContains(String keyword) {
        return hasText(keyword) ? barberShopEntity.name.containsIgnoreCase(keyword) : null;
    }


    private BooleanExpression inDistance(BigDecimal latitude, BigDecimal longitude, Double distance) {
        if (latitude == null || longitude == null || distance == null) {
            return null;
        }

        return Expressions.booleanTemplate(
                "CAST(is_within_distance({0}, {1}, {2}, {3}, {4}) AS boolean)",
                latitude,
                longitude,
                barberShopEntity.latitude,
                barberShopEntity.longitude,
                BigDecimal.valueOf(distance * 1000) // 0.5KM -> 500M
        );
    }
}
