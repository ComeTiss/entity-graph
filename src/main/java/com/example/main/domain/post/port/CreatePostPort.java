package com.example.main.domain.post.port;

import com.example.main.domain.post.Post;

import java.util.UUID;

public interface CreatePostPort {

    UUID createPost(Post post);
}
