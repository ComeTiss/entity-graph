package com.example.main.infrastructure.api.controller;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.usecase.CreatePostUseCase;
import com.example.main.infrastructure.api.dto.CreatePostRequest;
import com.example.main.infrastructure.api.dto.CreatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class CreatePostController {

    private CreatePostUseCase postService;

    @Autowired
    public CreatePostController(CreatePostUseCase postService) {
        this.postService = postService;
    }

    @PostMapping
    CreatePostResponse createPost(@RequestBody CreatePostRequest createPostRequest) {
       Post newPost = new Post(createPostRequest.title());
       UUID postId = postService.createPost(newPost);
       return new CreatePostResponse(postId);
    }
}
