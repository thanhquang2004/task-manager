package com.example.task_manager.repository;

import com.example.task_manager.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {
}
