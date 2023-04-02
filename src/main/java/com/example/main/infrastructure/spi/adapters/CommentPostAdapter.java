package com.example.main.infrastructure.spi.adapters;

import com.example.main.domain.comment.Comment;
import com.example.main.domain.comment.port.CommentPostPort;
import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.CommentRepository;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CommentPostAdapter implements CommentPostPort {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public UUID commentPost(UUID postId, Comment comment) {
        Optional<PostEntity> postOpt = postRepository.findById(postId);
        UUID commentId = null;

        if (postOpt.isPresent()) {
            commentId = commentPost(postOpt.get(), comment).getId();
        }

        return commentId;
    }

    private CommentEntity commentPost(PostEntity post, Comment comment) {
        CommentEntity postComment = CommentEntity.buildFrom(post, comment);
        return commentRepository.save(postComment);
    }
}
