package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;
import com.example.main.infrastructure.spi.entity.CommentEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class CommentEntityMapper {
    private CommentEntityMapper() {}

    public static Comment toComment(CommentEntity commentEntity) {
        return new Comment(
                new Id(commentEntity.getId().getId()),
                new Id(commentEntity.getPost().getId().getId()),
                commentEntity.getText()
        );
    }

    public static Set<Comment> toComments(Set<CommentEntity> commentEntities) {
        return commentEntities
                .stream()
                .map(CommentEntityMapper::toComment)
                .collect(Collectors.toSet());
    }
}
