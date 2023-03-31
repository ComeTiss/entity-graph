package com.example.main.domain;

import com.example.main.domain.post.Post;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    void should_create_post() {
        // GIVEN & WHEN
        String postTitle = "My post";
        Post post = Post.create(postTitle);

        // THEN
        assertThat(post).isNotNull();
        assertThat(post.getId()).isInstanceOf(UUID.class);
        assertThat(post.getTitle()).isEqualTo(postTitle);
    }
}
