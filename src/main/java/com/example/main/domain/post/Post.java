package com.example.main.domain.post;

import com.example.main.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Post {
    private final UUID id;
    private final String title;
    private final Set<Comment> comments;

    public Post(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.comments = new HashSet<>();
    }

    public Post(UUID id, String title) {
        this.id = id;
        this.title = title;
        this.comments = new HashSet<>();
    }
}
