package com.example.main.infrastructure.spi.adapters;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.ports.CreatePostPort;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePostAdapter implements CreatePostPort {

    @Autowired
    private PostRepository postRepository;

    @Override
    public UUID createPost(Post post) {
        PostEntity postEntitySaved = postRepository.save(PostEntity.buildFrom(post));
        return postEntitySaved.getId();
    }
}
