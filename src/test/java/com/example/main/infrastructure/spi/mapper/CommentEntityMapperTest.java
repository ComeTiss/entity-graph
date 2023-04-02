package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.comment.Comment;
import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.PostEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.main.fixtures.CommentEntityMockFactory.buildCommentEntityMock;
import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntitiesMock;
import static com.example.main.infrastructure.spi.mapper.CommentEntityMapper.toComment;
import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.toPosts;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentEntityMapperTest {

    @Test
    void should_map_comment_entity_to_comment_correctly() {
        // GIVEN
        CommentEntity commentEntity = buildCommentEntityMock();

        // WHEN
        Comment commentMapped = toComment(commentEntity);

        // THEN
        assertThat(commentMapped.getId()).isEqualTo(commentEntity.getId());
        assertThat(commentMapped.getPostId()).isEqualTo(commentEntity.getPost().getId());
        assertThat(commentMapped.getText()).isEqualTo(commentEntity.getText());
    }

    @Test
    void should_map_post_entities_to_posts_correctly() {
        // GIVEN
        List<PostEntity> postEntities = buildPostEntitiesMock();

        // WHEN
        List<Post> postsMapped = toPosts(postEntities);

        // THEN
        assertThat(postsMapped).hasSameSizeAs(postEntities);
        assertThat(postsMapped.get(0).getId()).isEqualTo(postEntities.get(0).getId());
        assertThat(postsMapped.get(0).getTitle()).isEqualTo(postEntities.get(0).getTitle());
    }
}
