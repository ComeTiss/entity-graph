package com.example.main.fixtures;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.api.dto.CreatePostRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class PostMockFactory {
    private PostMockFactory() {}

    public static final UUID POST_ID = UUID.randomUUID();
    public static final String POST_TITLE = "My great Post #1";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Post buildPostMock() {
        return new Post(POST_ID, POST_TITLE);
    }

    public static String buildFormattedCreatePostRequest() throws JsonProcessingException {
        CreatePostRequest createPostRequest = buildCreatePostRequest();
        return objectMapper.writeValueAsString(createPostRequest);
    }

    private static CreatePostRequest buildCreatePostRequest() {
        return new CreatePostRequest(POST_TITLE);
    }
}
