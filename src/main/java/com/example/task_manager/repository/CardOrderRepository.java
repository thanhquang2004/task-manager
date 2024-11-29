package com.example.task_manager.repository;

import com.example.task_manager.entity.CardComment;
import com.example.task_manager.entity.CardOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardOrderRepository extends JpaRepository<CardOrder, String> {
    CardOrder findByCardId(String cardId);
}
