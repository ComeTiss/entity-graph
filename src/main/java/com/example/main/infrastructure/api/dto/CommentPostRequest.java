package com.example.main.infrastructure.api.dto;

import java.util.UUID;

public record CommentPostRequest(UUID postId, String comment) {
}
