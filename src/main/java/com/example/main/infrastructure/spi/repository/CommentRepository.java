package com.example.main.infrastructure.spi.repository;

import com.example.main.infrastructure.spi.entity.CommentEntity;
import com.example.main.infrastructure.spi.entity.EntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, EntityId> {
}
