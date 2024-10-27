package com.example.task_manager.repository;

import com.example.task_manager.entity.CardAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardAttachmentRepository extends JpaRepository<CardAttachment, String> {
}
