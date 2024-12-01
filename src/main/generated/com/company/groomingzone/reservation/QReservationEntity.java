package com.company.groomingzone.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservationEntity is a Querydsl query type for ReservationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationEntity extends EntityPathBase<ReservationEntity> {

    private static final long serialVersionUID = -1102957367L;

    public static final QReservationEntity reservationEntity = new QReservationEntity("reservationEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberId = createNumber("barberId", Long.class);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    public final NumberPath<Long> barberShopScheduleId = createNumber("barberShopScheduleId", Long.class);

    public final NumberPath<Long> barberShopStyleId = createNumber("barberShopStyleId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath reservationStatus = createString("reservationStatus");

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QReservationEntity(String variable) {
        super(ReservationEntity.class, forVariable(variable));
    }

    public QReservationEntity(Path<? extends ReservationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservationEntity(PathMetadata metadata) {
        super(ReservationEntity.class, metadata);
    }

}

