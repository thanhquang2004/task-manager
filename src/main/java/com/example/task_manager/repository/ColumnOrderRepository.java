package com.example.task_manager.repository;

import com.example.task_manager.entity.ColumnOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnOrderRepository extends JpaRepository<ColumnOrder, String> {
}
