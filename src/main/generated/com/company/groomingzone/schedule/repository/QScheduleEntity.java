package com.company.groomingzone.schedule.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScheduleEntity is a Querydsl query type for ScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheduleEntity extends EntityPathBase<ScheduleEntity> {

    private static final long serialVersionUID = 567613899L;

    public static final QScheduleEntity scheduleEntity = new QScheduleEntity("scheduleEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberId = createNumber("barberId", Long.class);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final DateTimePath<java.time.OffsetDateTime> endTime = createDateTime("endTime", java.time.OffsetDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.company.groomingzone.schedule.domain.ScheduleStatus> scheduleStatus = createEnum("scheduleStatus", com.company.groomingzone.schedule.domain.ScheduleStatus.class);

    public final DateTimePath<java.time.OffsetDateTime> startTime = createDateTime("startTime", java.time.OffsetDateTime.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QScheduleEntity(String variable) {
        super(ScheduleEntity.class, forVariable(variable));
    }

    public QScheduleEntity(Path<? extends ScheduleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScheduleEntity(PathMetadata metadata) {
        super(ScheduleEntity.class, metadata);
    }

}

