package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class PostEntity {

    @Id
    private UUID id;

    private String title;

    public static PostEntity buildFrom(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getId());
        postEntity.setTitle(post.getTitle());
        return postEntity;
    }
}
