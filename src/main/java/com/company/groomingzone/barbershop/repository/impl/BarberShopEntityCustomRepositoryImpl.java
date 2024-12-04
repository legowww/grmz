package com.company.groomingzone.barbershop.repository.impl;

import com.company.groomingzone.barbershop.repository.BarberShopEntityCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BarberShopEntityCustomRepositoryImpl implements BarberShopEntityCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;


}
