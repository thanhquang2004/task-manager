package com.example.task_manager.repository;

import com.example.task_manager.entity.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardColumnRepository extends JpaRepository<BoardColumn, String> {
    List<BoardColumn> findAllByBoardId(String boardId);
}
