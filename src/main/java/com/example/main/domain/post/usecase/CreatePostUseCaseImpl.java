package com.example.main.domain.post.usecase;

import com.example.main.domain.Id;
import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.CreatePostPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {

    private final CreatePostPort createPostPort;

    @Override
    public Id createPost(Post post) {
        return createPostPort.createPost(post);
    }
}
