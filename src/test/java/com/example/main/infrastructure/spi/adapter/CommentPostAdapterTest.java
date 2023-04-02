package com.example.main.infrastructure.spi.adapter;

import com.example.main.domain.comment.Comment;
import com.example.main.infrastructure.spi.adapters.CommentPostAdapter;
import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.CommentRepository;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static com.example.main.fixtures.CommentEntityMockFactory.buildCommentEntityMock;
import static com.example.main.fixtures.CommentMockFactory.COMMENT_TEXT;
import static com.example.main.fixtures.CommentMockFactory.buildCommentMock;
import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntityMock;
import static com.example.main.fixtures.PostMockFactory.POST_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentPostAdapterTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentPostAdapter commentPostAdapter;

    @Test
    void should_comment_post_save_new_comment_when_post_exist() {
        // GIVEN
        UUID postIdExpected = POST_ID;
        PostEntity postEntity = buildPostEntityMock();
        Comment commentExpected = buildCommentMock();
        when(postRepository.findById(postIdExpected)).thenReturn(Optional.of(postEntity));
        when(commentRepository.save(any(CommentEntity.class))).thenReturn(CommentEntity.buildFrom(postEntity, commentExpected));

        // WHEN
        UUID commentPost = commentPostAdapter.commentPost(postIdExpected, commentExpected);

        // THEN
        assertThat(commentPost).isEqualTo(commentExpected.getId());
        verify(postRepository, atLeastOnce()).findById(any(UUID.class));
        verify(commentRepository, atLeastOnce()).save(any(CommentEntity.class));
    }

    @Test
    void should_comment_post_not_save_new_comment_when_post_does_not_exist() {
        // GIVEN
        UUID postIdExpected = POST_ID;
        Comment comment = buildCommentMock();
        when(postRepository.findById(postIdExpected)).thenReturn(Optional.empty());

        // WHEN
        UUID commentPost = commentPostAdapter.commentPost(postIdExpected, comment);

        // THEN
        assertThat(commentPost).isNull();
        verify(postRepository, atLeastOnce()).findById(any(UUID.class));
        verify(postRepository, never()).save(any(PostEntity.class));
    }
}
