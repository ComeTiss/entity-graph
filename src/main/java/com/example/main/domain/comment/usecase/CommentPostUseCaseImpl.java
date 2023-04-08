package com.example.main.domain.comment.usecase;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;
import com.example.main.domain.comment.port.CommentPostPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentPostUseCaseImpl implements CommentPostUseCase {

    private CommentPostPort commentPostPort;

    @Override
    public Id commentPost(Id postId, String commentText) {
        return commentPostPort.commentPost(postId, new Comment(postId, commentText));
    }
}
