package com.example.main.domain.comment.usecase;

import java.util.UUID;

public interface CommentPostUseCase {
    UUID commentPost(UUID postId, String commentText);
}
