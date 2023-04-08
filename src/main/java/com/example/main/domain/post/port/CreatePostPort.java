package com.example.main.domain.post.port;

import com.example.main.domain.Id;
import com.example.main.domain.post.Post;

public interface CreatePostPort {

    Id createPost(Post post);
}
