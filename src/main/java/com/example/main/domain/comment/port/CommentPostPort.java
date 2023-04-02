package com.example.main.domain.comment.port;

import com.example.main.domain.comment.Comment;

import java.util.UUID;

public interface CommentPostPort {
    UUID commentPost(UUID postId, Comment comment);
}
