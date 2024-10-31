package com.example.task_manager.service;

import com.example.task_manager.dto.request.CreateInvitationDto;
import com.example.task_manager.entity.Invitation;

public interface InvitationService {
    Invitation createInvitation(CreateInvitationDto createInvitationDto);
}
