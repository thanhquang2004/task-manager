package com.example.task_manager.repository;

import com.example.task_manager.entity.CardMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardMemberRepository extends JpaRepository<CardMember, String> {
    List<CardMember> findByCardId(String cardId);
    void deleteByCardIdAndUserId(String card_id, String userId);
}
