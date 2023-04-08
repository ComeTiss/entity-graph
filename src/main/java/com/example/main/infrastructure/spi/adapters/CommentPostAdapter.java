package com.example.main.infrastructure.spi.adapters;

import com.example.main.domain.Id;
import com.example.main.domain.comment.Comment;
import com.example.main.domain.comment.port.CommentPostPort;
import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.EntityId;
import com.example.main.infrastructure.spi.entity.PostEntity;
import com.example.main.infrastructure.spi.repository.CommentRepository;
import com.example.main.infrastructure.spi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentPostAdapter implements CommentPostPort {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Id commentPost(Id postId, Comment comment) {
        Optional<PostEntity> postOpt = postRepository.findById(new EntityId(postId));
        Id commentId = null;

        if (postOpt.isPresent()) {
            commentId = new Id(commentPost(postOpt.get(), comment).getId().getId());
        }

        return commentId;
    }

    private CommentEntity commentPost(PostEntity post, Comment comment) {
        CommentEntity postComment = CommentEntity.buildFrom(post, comment);
        return commentRepository.save(postComment);
    }
}
