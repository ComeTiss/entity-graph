package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class CommentEntity {

    @EmbeddedId
    private EntityId id = new EntityId();

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
    private PostEntity post;

    public static CommentEntity buildFrom(PostEntity post, Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(new EntityId(comment.getId()));
        commentEntity.setPost(post);
        commentEntity.setText(comment.getText());
        return commentEntity;
    }
}
