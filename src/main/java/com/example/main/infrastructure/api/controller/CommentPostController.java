package com.example.main.infrastructure.api.controller;

import com.example.main.domain.comment.Comment;
import com.example.main.domain.comment.usecase.CommentPostUseCase;
import com.example.main.domain.comment.usecase.CommentPostUseCaseImpl;
import com.example.main.domain.post.Post;
import com.example.main.infrastructure.api.dto.CommentPostRequest;
import com.example.main.infrastructure.api.dto.CommentPostResponse;
import com.example.main.infrastructure.api.dto.CreatePostRequest;
import com.example.main.infrastructure.api.dto.CreatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/posts/comments")
public class CommentPostController {

    private CommentPostUseCase commentService;

    @Autowired
    public CommentPostController(CommentPostUseCase commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    CommentPostResponse commentPost(@RequestBody CommentPostRequest commentPostRequest) {
       UUID commentId = commentService.commentPost(commentPostRequest.postId(), commentPostRequest.comment());
       return new CommentPostResponse(commentId);
    }
}
