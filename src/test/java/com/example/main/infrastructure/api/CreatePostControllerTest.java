package com.example.main.infrastructure.api;

import com.example.main.domain.Id;
import com.example.main.domain.post.usecase.CreatePostUseCase;
import com.example.main.infrastructure.api.controller.CreatePostController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildFormattedCreatePostRequest;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CreatePostController.class})
public class CreatePostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreatePostUseCase createPostUseCase;

    @Test
    void should_create_post_return_success() throws Exception {
        // GIVEN
        String requestBodyFormatted = buildFormattedCreatePostRequest();
        Id postIdExpected = POST_ID;
        when(createPostUseCase.createPost(any())).thenReturn(postIdExpected);

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId.value", is(postIdExpected.getValue().toString())));
    }
}
