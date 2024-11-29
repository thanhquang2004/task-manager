package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.BoardMemberRequestDto;
import com.example.task_manager.dto.response.BoardMemberResponse;
import com.example.task_manager.service.BoardMemberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardMemberServiceImpl implements BoardMemberService {

    private List<BoardMemberResponse> members = new ArrayList<>();

    @Override
    public BoardMemberResponse addMember(BoardMemberRequestDto request) {
        // Logic to add a board member
        BoardMemberResponse member = new BoardMemberResponse();
        member.setId((long) (members.size() + 1)); // Tạo ID giả cho thành viên
        member.setMemberName(request.getMemberName());
        member.setBoardId(request.getBoardId());
        members.add(member);
        return member;
    }

    @Override
    public List<BoardMemberResponse> getAllMembers() {
        return members;
    }

    @Override
    public BoardMemberResponse updateMember(Long id, BoardMemberRequestDto request) {
        for (BoardMemberResponse member : members) {
            if (member.getId().equals(id)) {
                member.setMemberName(request.getMemberName());
                member.setBoardId(request.getBoardId());
                return member; // Trả về thành viên đã cập nhật
            }
        }
        return null; // Nếu không tìm thấy thành viên
    }

    @Override
    public void removeMember(Long id) {
        members.removeIf(member -> member.getId().equals(id)); // Xóa thành viên theo ID
    }
}