package com.example.main.fixtures;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;
import com.example.main.domain.post.Post;
import com.example.main.infrastructure.api.dto.CommentPostRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;

public class CommentMockFactory {
    private CommentMockFactory() {}

    public static final Id COMMENT_ID = new Id();
    public static final String COMMENT_TEXT = "What a great post";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Comment buildCommentMock(Id postId) {
        return new Comment(postId, COMMENT_TEXT);
    }

    public static Comment buildCommentMock() {
        Post post = buildPostMock();
        return buildCommentMock(post.getId());
    }

    public static String buildFormattedCommentPostRequest(Id postId) throws JsonProcessingException {
        CommentPostRequest commentPostRequest = buildCommentPostRequest(postId);
        return objectMapper.writeValueAsString(commentPostRequest);
    }

    public static String buildFormattedCommentPostRequest() throws JsonProcessingException {
        CommentPostRequest commentPostRequest = buildCommentPostRequest(POST_ID);
        return objectMapper.writeValueAsString(commentPostRequest);
    }

    private static CommentPostRequest buildCommentPostRequest(Id postId) {
        return new CommentPostRequest(postId, COMMENT_TEXT);
    }
}
