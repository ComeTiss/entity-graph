package com.example.main.infrastructure.configuration;

import com.example.main.domain.post.PostService;
import com.example.main.domain.post.PostServiceImpl;
import com.example.main.domain.post.ports.CreatePostPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PostService postService(CreatePostPort createPostPort) {
        return new PostServiceImpl(createPostPort);
    }
}

