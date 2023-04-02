package com.example.main.infrastructure.api.testintegration;

import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.CommentRepository;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.example.main.fixtures.CommentMockFactory.COMMENT_TEXT;
import static com.example.main.fixtures.CommentMockFactory.buildFormattedCommentPostRequest;
import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CommentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void should_comment_post_successfully() throws Exception {
        // GIVEN
        PostEntity post = postRepository.save(PostEntity.buildFrom(buildPostMock()));
        String requestBodyFormatted = buildFormattedCommentPostRequest(post.getId());

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.commentId").value(notNullValue()));

        List<CommentEntity> comments = commentRepository.findAll();
        assertThat(comments.size()).isOne();
        assertThat(comments.get(0).getPost().getId()).isEqualTo(post.getId());
        assertThat(comments.get(0).getText()).isEqualTo(COMMENT_TEXT);
    }

    @Test
    void should_comment_post_fails_if_post_does_not_exist() throws Exception {
        // GIVEN
        String requestBodyFormatted = buildFormattedCommentPostRequest(POST_ID);

        // WHEN
        ResultActions result = mockMvc.perform(post("/posts/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyFormatted));

        // THEN
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.commentId").value(nullValue()));

        List<CommentEntity> comments = commentRepository.findAll();
        assertThat(comments).isEmpty();
    }
}
