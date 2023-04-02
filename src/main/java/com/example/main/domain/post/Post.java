package com.example.main.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Post {
    private final UUID id;
    private final String title;

    public Post(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }
}
