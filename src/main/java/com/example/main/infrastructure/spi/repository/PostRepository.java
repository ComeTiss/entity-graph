package com.example.main.infrastructure.spi.repository;

import com.example.main.infrastructure.spi.entity.EntityId;
import com.example.main.infrastructure.spi.entity.PostEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, EntityId> {
    @EntityGraph(value = "post-with-comments")
    List<PostEntity> findByIdNotNull();
}
