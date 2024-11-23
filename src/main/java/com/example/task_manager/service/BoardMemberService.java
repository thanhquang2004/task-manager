package com.example.task_manager.service;

import com.example.task_manager.dto.request.BoardMemberRequestDto;
import com.example.task_manager.dto.response.BoardMemberResponseDto;
import com.example.task_manager.dto.request.BoardMemberRequestDto;
import com.example.task_manager.dto.response.BoardMemberResponseDto;

import java.util.List;

public interface BoardMemberService {
    BoardMemberResponseDto addMember(BoardMemberRequestDto request);
    List<BoardMemberResponseDto> getAllMembers();
    BoardMemberResponseDto updateMember(Long id, BoardMemberRequestDto request);
    void removeMember(Long id);
}