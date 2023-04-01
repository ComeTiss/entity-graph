package com.example.main.domain.post.usecase;

import com.example.main.domain.post.Post;

import java.util.UUID;

public interface CreatePostUseCase {
    UUID createPost(Post post);
}
