package com.example.main.infrastructure.configuration;

import com.example.main.domain.post.port.CreatePostPort;
import com.example.main.domain.post.port.GetAllPostsPort;
import com.example.main.domain.post.usecase.CreatePostUseCase;
import com.example.main.domain.post.usecase.CreatePostUseCaseImpl;
import com.example.main.domain.post.usecase.GetAllPostsUseCase;
import com.example.main.domain.post.usecase.GetAllPostsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreatePostUseCase createPostUseCase(CreatePostPort createPostPort) {
        return new CreatePostUseCaseImpl(createPostPort);
    }

    @Bean
    GetAllPostsUseCase getAllPostsUseCase(GetAllPostsPort getAllPostsPort) {
        return new GetAllPostsUseCaseImpl(getAllPostsPort);
    }
}
