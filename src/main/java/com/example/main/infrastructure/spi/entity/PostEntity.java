package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NamedEntityGraph(
        name = "post-with-comments",
        attributeNodes =  {
                @NamedAttributeNode("comments")
        }
)
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

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<CommentEntity> comments = new HashSet<>();

    public static PostEntity buildFrom(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getId());
        postEntity.setTitle(post.getTitle());
        postEntity.setComments(new HashSet<>());
        return postEntity;
    }
}
