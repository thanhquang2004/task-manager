package com.example.task_manager.repository;

import com.example.task_manager.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
    @Query("SELECT b FROM Board b JOIN b.members m WHERE m.id = :userId")
    List<Board> findAllByMemberId(String userId);
}
