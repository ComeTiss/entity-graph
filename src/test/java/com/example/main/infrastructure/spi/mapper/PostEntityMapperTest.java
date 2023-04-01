package com.example.main.infrastructure.spi.mapper;

import com.example.main.domain.post.Post;
import com.example.main.infrastructure.spi.entity.PostEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntitiesMock;
import static com.example.main.fixtures.PostEntityMockFactory.buildPostEntityMock;
import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.toPost;
import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.toPosts;
import static org.assertj.core.api.Assertions.assertThat;

public class PostEntityMapperTest {

    @Test
    void should_map_post_entity_to_post_correctly() {
        // GIVEN
        PostEntity postEntity = buildPostEntityMock();

        // WHEN
        Post postMapped = toPost(postEntity);

        // THEN
        assertThat(postMapped.getId()).isEqualTo(postEntity.getId());
        assertThat(postMapped.getTitle()).isEqualTo(postEntity.getTitle());
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
