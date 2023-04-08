package com.example.main.domain.post.usecase;

import com.example.main.domain.Id;
import com.example.main.domain.post.Post;

public interface CreatePostUseCase {
    Id createPost(Post post);
}
