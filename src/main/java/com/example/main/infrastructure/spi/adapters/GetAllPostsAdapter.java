package com.example.main.infrastructure.spi.adapters;

import com.example.main.domain.post.Post;
import com.example.main.domain.post.port.GetAllPostsPort;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.toPosts;
import static com.example.main.infrastructure.spi.mapper.PostEntityMapper.toPostsDetails;

@Component
public class GetAllPostsAdapter implements GetAllPostsPort {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        List<PostEntity> postEntities = postRepository.findAll();
        return toPosts(postEntities);
    }

    @Override
    public List<Post> getAllPostsDetails() {
        List<PostEntity> postEntities = postRepository.findByIdNotNull();
        return toPostsDetails(postEntities);
    }
}
