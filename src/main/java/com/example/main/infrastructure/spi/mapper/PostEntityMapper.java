package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.entity.PostEntity;

import java.util.List;

import static com.example.main.infrastructure.spi.mapper.CommentEntityMapper.toComments;

public class PostEntityMapper {
    private PostEntityMapper() {}

    public static Post toPost(PostEntity postEntity) {
        return new Post(
                postEntity.getId(),
                postEntity.getTitle(),
                null);
    }

    public static Post toPostDetail(PostEntity postEntity) {
        return new Post(
                postEntity.getId(),
                postEntity.getTitle(),
                toComments(postEntity.getComments()));
    }


    public static List<Post> toPosts(List<PostEntity> postEntities) {
        return postEntities
                .stream()
                .map(PostEntityMapper::toPost)
                .toList();
    }

    public static List<Post> toPostsDetails(List<PostEntity> postEntities) {
        return postEntities
                .stream()
                .map(PostEntityMapper::toPostDetail)
                .toList();
    }
}
