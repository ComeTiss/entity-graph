package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.entity.PostEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.main.fixtures.PostEntityMockFactory.*;
import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PostEntityMapperTest {

    @Test
    void should_map_simple_post_entity_to_post_correctly() {
        // GIVEN
        PostEntity postEntity = buildPostEntityWithoutCommentMock();

        // WHEN
        Post postMapped = toPost(postEntity);

        // THEN
        assertThat(postMapped.getId()).isEqualTo(postEntity.getId());
        assertThat(postMapped.getTitle()).isEqualTo(postEntity.getTitle());
        assertThat(postMapped.getComments()).isNull();
    }

    @Test
    void should_map_simple_post_entities_to_posts_correctly() {
        // GIVEN
        List<PostEntity> postEntities = buildPostEntitiesWithoutCommentMock();

        // WHEN
        List<Post> postsMapped = toPosts(postEntities);

        // THEN
        assertThat(postsMapped).hasSameSizeAs(postEntities);
        assertThat(postsMapped.get(0).getId()).isEqualTo(postEntities.get(0).getId());
        assertThat(postsMapped.get(0).getTitle()).isEqualTo(postEntities.get(0).getTitle());
        assertThat(postsMapped.get(0).getComments()).isNull();
    }

    @Test
    void should_map_post_entity_with_children_to_post_correctly() {
        // GIVEN
        PostEntity postEntity = buildPostEntityMock();

        // WHEN
        Post postMapped = toPostDetail(postEntity);

        // THEN
        assertThat(postMapped.getId()).isEqualTo(postEntity.getId());
        assertThat(postMapped.getTitle()).isEqualTo(postEntity.getTitle());
        assertThat(postMapped.getComments()).hasSameSizeAs(postEntity.getComments());
    }

    @Test
    void should_map_post_entities_with_children_to_posts_correctly() {
        // GIVEN
        List<PostEntity> postEntities = buildPostEntitiesMock();

        // WHEN
        List<Post> postsMapped = toPostsDetails(postEntities);

        // THEN
        assertThat(postsMapped).hasSameSizeAs(postEntities);
        assertThat(postsMapped.get(0).getId()).isEqualTo(postEntities.get(0).getId());
        assertThat(postsMapped.get(0).getTitle()).isEqualTo(postEntities.get(0).getTitle());
        assertThat(postsMapped.get(0).getComments()).hasSameSizeAs(postEntities.get(0).getComments());
    }
}
