package com.example.task_manager.controller;


import com.example.task_manager.dto.request.BoardMemberRequestDto;
import com.example.task_manager.dto.response.BoardMemberResponse;
import com.example.task_manager.service.BoardMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board-members")
public class BoardMemberController {

    @Autowired
    private BoardMemberService boardMemberService;

    @PostMapping
    public BoardMemberResponse addMember(@RequestBody BoardMemberRequestDto request) {
        return boardMemberService.addMember(request);
    }

    @GetMapping
    public List<BoardMemberResponse> getAllMembers() {
        return boardMemberService.getAllMembers();
    }

    @PutMapping("/{id}")
    public BoardMemberResponse updateMember(@PathVariable Long id, @RequestBody BoardMemberRequestDto request) {
        return boardMemberService.updateMember(id, request);
    }

    @DeleteMapping("/{id}")
    public void removeMember(@PathVariable Long id) {
        boardMemberService.removeMember(id);
    }
}