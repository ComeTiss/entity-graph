package com.example.main.infrastructure.api.dto;

import com.example.main.domain.Id;

public record CommentPostRequest(Id postId, String comment) {
}
