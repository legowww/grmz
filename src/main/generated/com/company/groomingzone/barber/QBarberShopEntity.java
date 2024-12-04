package com.company.groomingzone.barber;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.company.groomingzone.barbershop.repository.BarberShopEntity;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBarberShopEntity is a Querydsl query type for BarberShopEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBarberShopEntity extends EntityPathBase<BarberShopEntity> {

    private static final long serialVersionUID = -1188375517L;

    public static final QBarberShopEntity barberShopEntity = new QBarberShopEntity("barberShopEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final BooleanPath isActive = createBoolean("isActive");

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> ownerId = createNumber("ownerId", Long.class);

    public final StringPath phone = createString("phone");

    public QBarberShopEntity(String variable) {
        super(BarberShopEntity.class, forVariable(variable));
    }

    public QBarberShopEntity(Path<? extends BarberShopEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBarberShopEntity(PathMetadata metadata) {
        super(BarberShopEntity.class, metadata);
    }

}

