package com.example.main.fixtures;

import com.example.main.infrastructure.spi.entity.PostEntity;

import java.util.List;

import static com.example.main.fixtures.PostMockFactory.buildPostMock;

public class PostEntityMockFactory {
    private PostEntityMockFactory() {}

    public static PostEntity buildPostEntityMock() {
        return PostEntity.buildFrom(buildPostMock());
    }
    public static List<PostEntity> buildPostEntitiesMock() {
        return List.of(buildPostEntityMock());
    }
}
