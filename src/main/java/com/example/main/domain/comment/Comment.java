package com.example.main.domain.comment;

import com.example.main.domain.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comment {
    private final Id id;
    private final Id postId;
    private final String text;

    public Comment(Id postId, String commentText) {
        this.id = new Id();
        this.postId = postId;
        this.text = commentText;
    }
}
