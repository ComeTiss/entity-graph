package com.example.main.infrastructure.api.controller;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.PostService;
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
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    CreatePostResponse createPost(@RequestBody CreatePostRequest createPostRequest) {
       Post newPost = Post.create(createPostRequest.title());
       UUID postId = postService.createPost(newPost);
       return new CreatePostResponse(postId);
    }
}
