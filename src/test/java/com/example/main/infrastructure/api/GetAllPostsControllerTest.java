package com.example.main.infrastructure.api;

import com.example.main.domain.post.usecase.GetAllPostsUseCase;
import com.example.main.infrastructure.api.controller.GetAllPostsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.main.fixtures.PostMockFactory.buildPostsMock;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {GetAllPostsController.class})
public class GetAllPostsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetAllPostsUseCase getAllPostsUseCase;

    @Test
    void should_get_all_posts_return_list_of_posts() throws Exception {
        // GIVEN
        when(getAllPostsUseCase.getAllPosts()).thenReturn(buildPostsMock());

        // WHEN
        ResultActions result = mockMvc.perform(get("/posts"));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts").value(notNullValue()));
    }
}
