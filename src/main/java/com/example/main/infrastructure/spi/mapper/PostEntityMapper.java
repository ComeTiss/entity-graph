package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.entity.PostEntity;

import java.util.List;

public class PostEntityMapper {
    private PostEntityMapper() {}

    public static Post toPost(PostEntity postEntity) {
        return new Post(postEntity.getId(), postEntity.getTitle());
    }

    public static List<Post> toPosts(List<PostEntity> postEntities) {
        return postEntities
                .stream()
                .map(PostEntityMapper::toPost)
                .toList();
    }
}
