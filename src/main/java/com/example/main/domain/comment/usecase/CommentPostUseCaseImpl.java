package com.example.main.domain.comment.usecase;

import com.example.main.domain.comment.Comment;
import com.example.main.domain.comment.port.CommentPostPort;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CommentPostUseCaseImpl implements CommentPostUseCase {

    private CommentPostPort commentPostPort;

    @Override
    public UUID commentPost(UUID postId, String commentText) {
        return commentPostPort.commentPost(postId, new Comment(postId, commentText));
    }
}
