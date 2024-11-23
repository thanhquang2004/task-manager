package com.example.task_manager.repository;

import com.example.task_manager.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh ở đây nếu cần
}