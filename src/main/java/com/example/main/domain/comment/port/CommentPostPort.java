package com.example.main.domain.comment.port;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;

public interface CommentPostPort {
    Id commentPost(Id postId, Comment comment);
}
