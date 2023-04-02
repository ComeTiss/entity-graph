package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class CommentEntity {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private PostEntity post;

    public static CommentEntity buildFrom(PostEntity post, Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getId());
        commentEntity.setPost(post);
        commentEntity.setText(comment.getText());
        return commentEntity;
    }
}
