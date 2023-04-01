package com.example.main.domain;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.CreatePostPort;
import com.example.main.domain.post.usecase.CreatePostUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreatePostUseCaseImplTest {

    @Mock
    private CreatePostPort createPostPort;

    @InjectMocks
    private CreatePostUseCaseImpl postService;

    @Test
    void should_create_post_call_port() {
        // GIVEN
        UUID postIdExpected = POST_ID;
        Post newPost = buildPostMock();
        when(createPostPort.createPost(any(Post.class))).thenReturn(postIdExpected);

        // WHEN
        UUID postId = postService.createPost(newPost);

        // THEN
        assertThat(postId).isEqualTo(postIdExpected);
        verify(createPostPort, atLeastOnce()).createPost(any());
    }
}
