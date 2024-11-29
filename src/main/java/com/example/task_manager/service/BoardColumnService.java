package com.example.task_manager.service;


import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponse;
import com.example.task_manager.dto.response.ColumnOrderResponse;
import com.example.task_manager.entity.ColumnOrder;

import java.util.List;

public interface BoardColumnService {
    BoardColumnResponse createColumn(BoardColumnRequestDto request);
    List<BoardColumnResponse> getAllColumnsByBoardId(String boardId);
    BoardColumnResponse updateColumn(String id, BoardColumnRequestDto request);
    List<ColumnOrderResponse> updateColumnOrder(List<String> columnOrderIds, String boardId);
    void deleteColumn(String id);
}