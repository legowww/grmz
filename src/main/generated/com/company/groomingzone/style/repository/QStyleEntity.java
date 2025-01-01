package com.company.groomingzone.style.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStyleEntity is a Querydsl query type for StyleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStyleEntity extends EntityPathBase<StyleEntity> {

    private static final long serialVersionUID = 1835109841L;

    public static final QStyleEntity styleEntity = new QStyleEntity("styleEntity");

    public final com.company.groomingzone.common.QBaseEntity _super = new com.company.groomingzone.common.QBaseEntity(this);

    public final NumberPath<Long> barberId = createNumber("barberId", Long.class);

    public final NumberPath<Long> barberShopId = createNumber("barberShopId", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final EnumPath<com.company.groomingzone.style.domain.StyleCategory> styleCategory = createEnum("styleCategory", com.company.groomingzone.style.domain.StyleCategory.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public final StringPath url = createString("url");

    public QStyleEntity(String variable) {
        super(StyleEntity.class, forVariable(variable));
    }

    public QStyleEntity(Path<? extends StyleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStyleEntity(PathMetadata metadata) {
        super(StyleEntity.class, metadata);
    }

}

