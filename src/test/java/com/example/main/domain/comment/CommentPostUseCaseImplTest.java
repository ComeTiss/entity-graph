package com.example.main.domain.comment;

import com.example.main.domain.Id;
import com.example.main.domain.comment.port.CommentPostPort;
import com.example.main.domain.comment.usecase.CommentPostUseCaseImpl;
import com.example.main.domain.post.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.main.fixtures.CommentMockFactory.COMMENT_ID;
import static com.example.main.fixtures.CommentMockFactory.COMMENT_TEXT;
import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentPostUseCaseImplTest {

    @Mock
    private CommentPostPort commentPostPort;

    @InjectMocks
    private CommentPostUseCaseImpl commentService;

    @Test
    void should_create_post_call_port() {
        // GIVEN
        Id commentIdExpected = COMMENT_ID;
        String commentTextExpected = COMMENT_TEXT;
        Post post = buildPostMock();
        when(commentPostPort.commentPost(any(Id.class), any(Comment.class))).thenReturn(commentIdExpected);

        // WHEN
        Id commentId = commentService.commentPost(post.getId(), commentTextExpected);

        // THEN
        assertThat(commentId).isEqualTo(commentIdExpected);
        verify(commentPostPort, atLeastOnce()).commentPost(any(Id.class), any(Comment.class));
    }
}
