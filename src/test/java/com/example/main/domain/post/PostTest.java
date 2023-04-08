package com.example.main.domain.post;

import com.example.main.domain.Id;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    void should_construct_post_object() {
        // GIVEN & WHEN
        String postTitle = "My post";
        Post post = new Post(postTitle);

        // THEN
        assertThat(post).isNotNull();
        assertThat(post.getId()).isInstanceOf(Id.class);
        assertThat(post.getTitle()).isEqualTo(postTitle);
    }
}
