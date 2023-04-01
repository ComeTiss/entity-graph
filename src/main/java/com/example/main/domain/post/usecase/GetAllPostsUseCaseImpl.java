package com.example.main.domain.post.usecase;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.GetAllPostsPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllPostsUseCaseImpl implements GetAllPostsUseCase {

    private final GetAllPostsPort getAllPostsPort;

    @Override
    public List<Post> getAllPosts() {
        return getAllPostsPort.getAllPosts();
    }
}
