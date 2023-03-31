package com.example.main.infrastructure.api;

import com.example.main.infrastructure.api.dto.CreatePostRequest;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    void should_create_post_successfully() throws Exception {
        // GIVEN
        CreatePostRequest requestBody = new CreatePostRequest("A great post #1");
        String requestBodyFormatted = objectMapper.writeValueAsString(requestBody);

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId").value(notNullValue()));

        List<PostEntity> posts = postRepository.findAll();
        assertThat(posts.size()).isOne();
    }
}
