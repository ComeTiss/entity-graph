package com.example.main.infrastructure.api.dto;

import com.example.main.domain.post.Post;

import java.util.List;

public record GetAllPostsResponse(List<Post> posts) {
}
