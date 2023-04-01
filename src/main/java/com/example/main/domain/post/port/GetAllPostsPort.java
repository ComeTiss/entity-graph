package com.example.main.domain.post.port;

import com.example.main.domain.post.Post;

import java.util.List;

public interface GetAllPostsPort {

    List<Post> getAllPosts();
}
