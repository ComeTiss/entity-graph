package com.example.main.domain.comment;

import com.example.main.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Comment {
    private final UUID id;
    private final UUID postId;
    private final String text;

    public Comment(UUID postId, String commentText) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.text = commentText;
    }
}
