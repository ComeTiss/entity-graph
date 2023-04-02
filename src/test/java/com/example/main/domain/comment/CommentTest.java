package com.example.main.domain.comment;

import com.example.main.domain.post.Post;
import org.junit.jupiter.api.Test;

import static com.example.main.fixtures.PostMockFactory.buildPostMock;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentTest {

    @Test
    void should_construct_comment_object() {
        // GIVEN
        Post post = buildPostMock();
        String commentText = "A great post, well done.";

        // WHEN
        Comment comment = new Comment(post.getId(), commentText);

        // THEN
        assertThat(comment.getId()).isNotNull();
        assertThat(comment.getPostId()).isEqualTo(post.getId());
        assertThat(comment.getText()).isEqualTo(commentText);
    }
}
