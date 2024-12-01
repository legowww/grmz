package com.company.groomingzone.barber;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBarberEntity is a Querydsl query type for BarberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBarberEntity extends EntityPathBase<BarberEntity> {

    private static final long serialVersionUID = 696386189L;

    public static final QBarberEntity barberEntity = new QBarberEntity("barberEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final BooleanPath isActive = createBoolean("isActive");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QBarberEntity(String variable) {
        super(BarberEntity.class, forVariable(variable));
    }

    public QBarberEntity(Path<? extends BarberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBarberEntity(PathMetadata metadata) {
        super(BarberEntity.class, metadata);
    }

}

