package com.example.main.domain.post;

import com.example.main.domain.post.ports.CreatePostPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService  {

    private final CreatePostPort createPostPort;

    @Override
    public UUID createPost(Post post) {
        return createPostPort.createPost(post);
    }
}
