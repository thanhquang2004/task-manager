package com.example.task_manager.repository;

import com.example.task_manager.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, String> {
}
