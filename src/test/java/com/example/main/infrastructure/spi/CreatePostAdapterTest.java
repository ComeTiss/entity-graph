package com.example.main.infrastructure.spi;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.adapters.CreatePostAdapter;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
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
public class CreatePostAdapterTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CreatePostAdapter createPostAdapter;

    @Test
    void should_create_post_call_persistence_layer() {
        // GIVEN
        UUID postIdExpected = UUID.randomUUID();
        Post newPost = new Post(postIdExpected, "My post");
        when(postRepository.save(any(PostEntity.class))).thenReturn(PostEntity.buildFrom(newPost));

        // WHEN
        UUID postId = createPostAdapter.createPost(newPost);

        // THEN
        assertThat(postId).isEqualTo(postIdExpected);
        verify(postRepository, atLeastOnce()).save(any(PostEntity.class));
    }
}
