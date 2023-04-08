package com.example.main.infrastructure.api;

import com.example.main.domain.Id;
import com.example.main.domain.comment.usecase.CommentPostUseCase;
import com.example.main.infrastructure.api.controller.CommentPostController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.main.fixtures.CommentMockFactory.COMMENT_ID;
import static com.example.main.fixtures.CommentMockFactory.buildFormattedCommentPostRequest;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CommentPostController.class})
public class CommentPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentPostUseCase commentPostUseCase;

    @Test
    void should_comment_post_return_success() throws Exception {
        // GIVEN
        String requestBodyFormatted = buildFormattedCommentPostRequest();
        Id commentIdExpected = COMMENT_ID;
        when(commentPostUseCase.commentPost(any(), any())).thenReturn(commentIdExpected);

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.commentId.value", is(commentIdExpected.getValue().toString())));
    }
}
