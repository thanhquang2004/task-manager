package com.example.task_manager.repository;

import com.example.task_manager.entity.ColumnOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnOrderRepository extends JpaRepository<ColumnOrder, String> {
    List<ColumnOrder> findAllByBoardId(String boardId);
    ColumnOrder findByColumnId(String columnId);
}
