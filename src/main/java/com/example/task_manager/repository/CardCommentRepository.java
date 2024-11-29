package com.example.task_manager.repository;

import com.example.task_manager.entity.CardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardCommentRepository extends JpaRepository<CardComment, String> {
    List<CardComment> findByCardId(String cardId);
}
