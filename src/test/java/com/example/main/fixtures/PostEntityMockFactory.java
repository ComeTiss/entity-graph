package com.example.main.fixtures;

import com.example.main.infrastructure.spi.entity.PostEntity;

import java.util.List;

import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static com.example.main.fixtures.PostMockFactory.buildPostWithoutCommentMock;

public class PostEntityMockFactory {
    private PostEntityMockFactory() {}
    public static PostEntity buildPostEntityMock() {
        return PostEntity.buildFrom(buildPostMock());
    }

    public static List<PostEntity> buildPostEntitiesMock() {
        return List.of(buildPostEntityMock());
    }

    public static PostEntity buildPostEntityWithoutCommentMock() {
        return PostEntity.buildFrom(buildPostWithoutCommentMock());
    }

    public static List<PostEntity> buildPostEntitiesWithoutCommentMock() {
        return List.of(buildPostEntityWithoutCommentMock());
    }

}
