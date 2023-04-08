package com.example.main.infrastructure.spi.adapters;

import com.example.main.domain.Id;
import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.CreatePostPort;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreatePostAdapter implements CreatePostPort {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Override
    public Id createPost(Post post) {
        PostEntity postEntitySaved = postRepository.save(PostEntity.buildFrom(post));
        return new Id(postEntitySaved.getId().getId());
    }
}
