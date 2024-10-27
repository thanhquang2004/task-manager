package com.example.task_manager.repository;

import com.example.task_manager.entity.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, String> {
}
