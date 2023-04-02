package com.example.main.fixtures;

import com.example.main.domain.comment.Comment;
import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.PostEntity;

import java.util.List;

import static com.example.main.fixtures.CommentMockFactory.buildCommentMock;
import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntityMock;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;

public class CommentEntityMockFactory {
    private CommentEntityMockFactory() {}

    public static CommentEntity buildCommentEntityMock() {
        Comment comment = buildCommentMock();
        PostEntity postEntity = buildPostEntityMock();
        return CommentEntity.buildFrom(postEntity, comment);
    }
    public static List<CommentEntity> buildCommentEntitiesMock() {
        return List.of(buildCommentEntityMock());
    }
}
