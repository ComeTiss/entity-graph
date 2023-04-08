package com.example.main.infrastructure.spi.adapter;

import com.example.main.domain.Id;
import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.adapters.CreatePostAdapter;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;
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
        Id postIdExpected = POST_ID;
        Post newPost = buildPostMock();
        when(postRepository.save(any(PostEntity.class))).thenReturn(PostEntity.buildFrom(newPost));

        // WHEN
        Id postId = createPostAdapter.createPost(newPost);

        // THEN
        assertThat(postId.getValue()).isEqualTo(postIdExpected.getValue());
        verify(postRepository, atLeastOnce()).save(any(PostEntity.class));
    }
}
