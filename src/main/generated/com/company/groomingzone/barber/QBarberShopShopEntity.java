package com.company.groomingzone.barber;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBarberShopShopEntity is a Querydsl query type for BarberShopShopEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBarberShopShopEntity extends EntityPathBase<BarberShopShopEntity> {

    private static final long serialVersionUID = -1102779719L;

    public static final QBarberShopShopEntity barberShopShopEntity = new QBarberShopShopEntity("barberShopShopEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberId = createNumber("barberId", Long.class);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QBarberShopShopEntity(String variable) {
        super(BarberShopShopEntity.class, forVariable(variable));
    }

    public QBarberShopShopEntity(Path<? extends BarberShopShopEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBarberShopShopEntity(PathMetadata metadata) {
        super(BarberShopShopEntity.class, metadata);
    }

}

