package com.example.main.domain.comment.usecase;

import com.example.main.domain.Id;

public interface CommentPostUseCase {
    Id commentPost(Id postId, String commentText);
}
