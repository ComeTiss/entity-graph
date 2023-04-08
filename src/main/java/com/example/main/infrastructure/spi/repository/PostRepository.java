package com.example.main.infrastructure.spi.repository;

import com.example.main.infrastructure.spi.entity.PostEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    @EntityGraph(value = "post-with-comments")
    List<PostEntity> findByIdNotNull();
}
