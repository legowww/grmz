package com.company.groomingzone.barbershopschedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.company.groomingzone.barbershopschedule.infra.BarberShopScheduleEntity;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBarberShopScheduleEntity is a Querydsl query type for BarberShopScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBarberShopScheduleEntity extends EntityPathBase<BarberShopScheduleEntity> {

    private static final long serialVersionUID = -109238611L;

    public static final QBarberShopScheduleEntity barberShopScheduleEntity = new QBarberShopScheduleEntity("barberShopScheduleEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberId = createNumber("barberId", Long.class);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final DateTimePath<java.time.OffsetDateTime> dateTime = createDateTime("dateTime", java.time.OffsetDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QBarberShopScheduleEntity(String variable) {
        super(BarberShopScheduleEntity.class, forVariable(variable));
    }

    public QBarberShopScheduleEntity(Path<? extends BarberShopScheduleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBarberShopScheduleEntity(PathMetadata metadata) {
        super(BarberShopScheduleEntity.class, metadata);
    }

}

