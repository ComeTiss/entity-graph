package com.example.main.infrastructure.api;

import com.example.main.domain.post.PostService;
import com.example.main.infrastructure.api.dto.CreatePostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @Test
    void should_create_post_return_success() throws Exception {
        // GIVEN
        CreatePostRequest requestBody = new CreatePostRequest("A great post #1");
        String requestBodyFormatted = objectMapper.writeValueAsString(requestBody);
        UUID postIdExpected = UUID.randomUUID();
        when(postService.createPost(any())).thenReturn(postIdExpected);

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId", is(postIdExpected.toString())));
    }
}
