package com.example.main.infrastructure.api.controller;

import com.example.main.domain.post.usecase.GetAllPostsUseCase;
import com.example.main.infrastructure.api.dto.GetAllPostsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class GetAllPostsController {

    private final GetAllPostsUseCase postService;

    @Autowired
    public GetAllPostsController(GetAllPostsUseCase postService) {
        this.postService = postService;
    }

    @GetMapping
    GetAllPostsResponse getAllPosts() {
        return new GetAllPostsResponse(postService.getAllPosts());
    }
}
