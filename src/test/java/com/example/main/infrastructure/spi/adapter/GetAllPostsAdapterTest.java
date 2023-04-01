package com.example.main.infrastructure.spi.adapter;

import com.example.main.domain.post.Post;
import com.example.main.fixtures.PostEntityMockFactory;
import com.example.main.infrastructure.spi.adapters.CreatePostAdapter;
import com.example.main.infrastructure.spi.adapters.GetAllPostsAdapter;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntitiesMock;
import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAllPostsAdapterTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private GetAllPostsAdapter getAllPostsAdapter;

    @Test
    void should_get_all_posts_call_persistence_layer() {
        // GIVEN
        when(postRepository.findAll()).thenReturn(buildPostEntitiesMock());

        // WHEN
        List<Post> posts = getAllPostsAdapter.getAllPosts();

        // THEN
        assertThat(posts).hasSize(1);
        verify(postRepository, atLeastOnce()).findAll();
    }
}
