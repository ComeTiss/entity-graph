package com.example.main.domain;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.PostServiceImpl;
import com.example.main.domain.post.ports.CreatePostPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    private CreatePostPort createPostPort;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void should_create_post_successfully() {
        // GIVEN
        UUID postIdExpected = UUID.randomUUID();
        Post newPost = new Post(postIdExpected, "My post");
        when(createPostPort.createPost(any(Post.class))).thenReturn(postIdExpected);

        // WHEN
        UUID postId = postService.createPost(newPost);

        // THEN
        assertThat(postId).isEqualTo(postIdExpected);
        verify(createPostPort, atLeastOnce()).createPost(any());
    }
}
