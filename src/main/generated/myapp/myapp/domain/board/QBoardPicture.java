package myapp.myapp.domain.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardPicture is a Querydsl query type for BoardPicture
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardPicture extends EntityPathBase<BoardPicture> {

    private static final long serialVersionUID = 289784344L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardPicture boardPicture = new QBoardPicture("boardPicture");

    public final myapp.myapp.domain.QBaseTimeEntity _super = new myapp.myapp.domain.QBaseTimeEntity(this);

    public final QBoard board;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath pictureUrl = createString("pictureUrl");

    public QBoardPicture(String variable) {
        this(BoardPicture.class, forVariable(variable), INITS);
    }

    public QBoardPicture(Path<? extends BoardPicture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardPicture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardPicture(PathMetadata metadata, PathInits inits) {
        this(BoardPicture.class, metadata, inits);
    }

    public QBoardPicture(Class<? extends BoardPicture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board")) : null;
    }

}

