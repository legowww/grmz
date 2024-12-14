package com.company.groomingzone.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSystemCode is a Querydsl query type for SystemCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSystemCode extends EntityPathBase<SystemCode> {

    private static final long serialVersionUID = 927891067L;

    public static final QSystemCode systemCode = new QSystemCode("systemCode");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    public final StringPath codeGroup = createString("codeGroup");

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> createdTs = _super.createdTs;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> updatedTs = _super.updatedTs;

    public QSystemCode(String variable) {
        super(SystemCode.class, forVariable(variable));
    }

    public QSystemCode(Path<? extends SystemCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSystemCode(PathMetadata metadata) {
        super(SystemCode.class, metadata);
    }

}

