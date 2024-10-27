package com.example.task_manager.repository;

import com.example.task_manager.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
