package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class PostEntity {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String title;

    @OneToMany(mappedBy = "post")
    private Set<CommentEntity> comments;

    public static PostEntity buildFrom(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getId());
        postEntity.setTitle(post.getTitle());
        postEntity.setComments(new HashSet<>());
        return postEntity;
    }
}
