package com.example.main.domain.post;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Post {
    private final Id id;
    private final String title;
    private final Set<Comment> comments;

    public Post(String title) {
        this.id = new Id();
        this.title = title;
        this.comments = new HashSet<>();
    }

    public Post(Id id, String title) {
        this.id = id;
        this.title = title;
        this.comments = new HashSet<>();
    }
}
