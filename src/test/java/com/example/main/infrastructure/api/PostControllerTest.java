package com.example.main.infrastructure.api;

import com.example.main.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildFormattedCreatePostRequest;
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

    @MockBean
    private PostService postService;

    @Test
    void should_create_post_return_success() throws Exception {
        // GIVEN
        String requestBodyFormatted = buildFormattedCreatePostRequest();
        UUID postIdExpected = POST_ID;
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
