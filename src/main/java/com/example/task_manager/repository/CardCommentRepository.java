package com.example.task_manager.repository;

import com.example.task_manager.entity.CardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardCommentRepository extends JpaRepository<CardComment, String> {
}
