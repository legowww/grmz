package com.company.groomingzone.barbershop.repository.impl;

import com.company.groomingzone.barbershop.domain.BarberShopSearchCondition;
import com.company.groomingzone.barbershop.domain.BarberShopInfo;
import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.company.groomingzone.common.repository.ListQueryResponse;
import com.company.groomingzone.common.repository.SingleSortCondition;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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
    public ListQueryResponse<BarberShopInfo> findBarberShopList(BarberShopSearchCondition condition) {
        List<BarberShopInfo> content = jpaQueryFactory
                .select(Projections.constructor(BarberShopInfo.class,
                        barberShopEntity.id,
                        barberShopEntity.name,
                        barberShopEntity.name
                ))
                .from(barberShopEntity)
                .where(
                        barberShopEntity.isActive.eq(true),
                        nameContains(condition.getKeyword()),
                        inDistance(condition.getLatitude(), condition.getLongitude(), condition.getDistance())
                )
                .offset(condition.getOffset())
                .limit(condition.getScrollLimit())
                .orderBy(getOrder(condition.getSortCondition()))
                .fetch();

        return ListQueryResponse.createScrollResponse(content, condition);
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
