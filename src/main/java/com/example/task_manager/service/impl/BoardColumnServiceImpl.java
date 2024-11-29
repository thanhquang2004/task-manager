package com.example.task_manager.service.impl;


import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponse;

import com.example.task_manager.dto.response.ColumnOrderResponse;
import com.example.task_manager.entity.Board;
import com.example.task_manager.entity.BoardColumn;
import com.example.task_manager.entity.ColumnOrder;
import com.example.task_manager.mapper.BoardColumnMapper;
import com.example.task_manager.mapper.ColumnOrderMapper;
import com.example.task_manager.repository.BoardColumnRepository;
import com.example.task_manager.repository.BoardRepository;
import com.example.task_manager.repository.ColumnOrderRepository;
import com.example.task_manager.service.BoardColumnService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BoardColumnServiceImpl implements BoardColumnService {
    BoardColumnRepository boardColumnRepository;
    BoardRepository boardRepository;
    ColumnOrderRepository columnOrderRepository;
    //    BoardMapper boardMapper;
    BoardColumnMapper boardColumnMapper;
    ColumnOrderMapper columnOrderMapper;


    @Override
    public BoardColumnResponse createColumn(BoardColumnRequestDto request) {
//        log.info("request: {}", request);
        // Logic to create a column
        Board board = boardRepository.findById(request.getBoard_id()).orElseThrow(() -> new RuntimeException("Board not found"));
        log.info("board: {}", board.getId());
        List<ColumnOrder> columnOrders = board.getColumnOrders();
//        log.info("columnOrders: {}", columnOrders);
        Integer maxPosition = columnOrders.stream().map(ColumnOrder::getPosition).max(Integer::compareTo).orElse(0);

        log.info("maxPosition: {}", maxPosition);
        BoardColumn boardColumn = boardColumnMapper.toEntity(request);
        boardColumn.setBoard(board);
//        log.info("boardColumn: {}", boardColumn);
        BoardColumn newColumn = boardColumnRepository.save(boardColumn);
        ColumnOrder columnOrder = ColumnOrder.builder()
                .position(maxPosition + 1)
                .board(board)
                .column(newColumn)
                .build();
//        log.info("columnOrder: {}", columnOrder);
        columnOrderRepository.save(columnOrder);

        BoardColumnResponse response = boardColumnMapper.toResponse(newColumn);
        response.setBoardId(newColumn.getBoard().getId());
        return response;

    }

    @Override
    public List<BoardColumnResponse> getAllColumnsByBoardId(String id) {
        return boardColumnMapper.toResponseList(boardColumnRepository.findAllByBoardId(id));
    }

    @Override
    public List<ColumnOrderResponse> updateColumnOrder(List<String> columnOrderIds, String boardId) {
        // Logic to update column order
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));

        for (int i = 0; i < columnOrderIds.size(); i++) {
            log.info("columnOrderIds: {}", columnOrderIds.get(i));
            ColumnOrder columnOrder = columnOrderRepository.findByColumnId(columnOrderIds.get(i));
            if (columnOrder == null) {
                throw new RuntimeException("Column not found");
            }

            columnOrder.setPosition(i);
            columnOrderRepository.save(columnOrder);
        }

        return columnOrderMapper.toListResponse(columnOrderRepository.findAllByBoardId(boardId));

    }

    @Override
    public BoardColumnResponse updateColumn(String id, BoardColumnRequestDto request) {
        // Logic to update a column
        return null; // Return updated column
    }

    @Override
    public void deleteColumn(String id) {
        // Logic to delete a column
    }
}