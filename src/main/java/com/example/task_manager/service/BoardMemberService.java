package com.example.task_manager.service;

import com.example.task_manager.dto.request.BoardMemberRequestDto;
import com.example.task_manager.dto.response.BoardMemberResponse;

import java.util.List;

public interface BoardMemberService {
    BoardMemberResponse addMember(BoardMemberRequestDto request);
    List<BoardMemberResponse> getAllMembers();
    BoardMemberResponse updateMember(Long id, BoardMemberRequestDto request);
    void removeMember(Long id);
}