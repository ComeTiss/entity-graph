package com.example.main.domain.post;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.GetAllPostsPort;
import com.example.main.domain.post.usecase.GetAllPostsUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.main.fixtures.PostMockFactory.buildPostsMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAllPostsUseCaseImplTest {

    @Mock
    private GetAllPostsPort getAllPostsPort;

    @InjectMocks
    private GetAllPostsUseCaseImpl getAllPostsUseCase;

    @Test
    void should_get_all_posts_call_port() {
        // GIVEN
        when(getAllPostsPort.getAllPosts()).thenReturn(buildPostsMock());

        // WHEN
        List<Post> posts = getAllPostsUseCase.getAllPosts();

        // THEN
        assertThat(posts.size()).isOne();
        verify(getAllPostsPort, atLeastOnce()).getAllPosts();
    }
}
