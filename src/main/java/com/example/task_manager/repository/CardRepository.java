package com.example.task_manager.repository;

import com.example.task_manager.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findAllByColumnId(String columnId);
}
