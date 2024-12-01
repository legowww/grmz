package com.company.groomingzone.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = -938520621L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final DateTimePath<java.time.OffsetDateTime> createdTs = createDateTime("createdTs", java.time.OffsetDateTime.class);

    public final DateTimePath<java.time.OffsetDateTime> updatedTs = createDateTime("updatedTs", java.time.OffsetDateTime.class);

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

