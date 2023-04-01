package com.example.main.domain.post.usecase;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.CreatePostPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {

    private final CreatePostPort createPostPort;

    @Override
    public UUID createPost(Post post) {
        return createPostPort.createPost(post);
    }
}
