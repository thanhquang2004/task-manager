package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponse;
import com.example.task_manager.dto.response.BoardResponse;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.Board;

import com.example.task_manager.entity.CardOrder;
import com.example.task_manager.entity.ColumnOrder;
import com.example.task_manager.entity.User;
import com.example.task_manager.mapper.BoardMapper;
import com.example.task_manager.mapper.UserMapper;
import com.example.task_manager.repository.BoardColumnRepository;
import com.example.task_manager.repository.BoardRepository;
import com.example.task_manager.repository.CardRepository;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.service.BoardService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BoardServiceImpl implements BoardService {
    UserRepository userRepository;
    BoardRepository boardRepository;
    BoardColumnRepository boardColumnRepository;
    CardRepository cardRepository;
    UserMapper userMapper;
    BoardMapper boardMapper;

    UserResponse getCurrentUser() {
        // Logic to get current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("credentials: {}", authentication);
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toUserResponse(user); // Return current user
    }

    List<String> sortedColumnIds(List<ColumnOrder> columns) {


        return columns.stream()
                .sorted(Comparator.comparingInt(ColumnOrder::getPosition))
                .map(columnOrder -> columnOrder.getColumn().getId())
                .collect(Collectors.toList());

    }

    List<String> sortedCardIds(List<CardOrder> cards) {
        return cards.stream()
                .sorted(Comparator.comparingInt(CardOrder::getPosition))
                .map(cardOrder -> cardOrder.getCard().getId())
                .collect(Collectors.toList());
    }

    List<CardResponse> getCardsByColumnId(String columnId, String boardId) {
        return cardRepository.findAllByColumnId(columnId).stream()
                .map(card -> {
                    CardResponse cardResponse = new CardResponse();
                    cardResponse.setId(card.getId());
                    cardResponse.setTitle(card.getTitle());
                    cardResponse.setDescription(card.getDescription());
                    cardResponse.setColumnId(card.getColumn().getId());
                    cardResponse.setBoardId(boardId);
                    return cardResponse;
                })
                .toList();
    }

    @Override
    public BoardResponse createBoard(BoardRequestDto request) {
        // Logic to create a board
        UserResponse user = getCurrentUser();
        Board board = boardMapper.toEntity(request);
        log.info("User: {}", user);
        User currentUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        board.setDestroyed(false);

        board.setMembers(Collections.singletonList(currentUser));

        return boardMapper.toResponse(boardRepository.save(board));
    }

    @Override
    public List<BoardResponse> getAllBoardsByUser() {
        UserResponse user = getCurrentUser();
        List<Board> boards = boardRepository.findAllByMemberId(user.getId());

        return boards.stream().map(boardMapper::toResponse).toList();
    }

    @Override
    public BoardResponse getBoardDetailById(String id) {
        // Logic to get board detail
        log.info("Getting board detail for board id: {}", id);
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
//        log.info("Board: {}", board);
        BoardResponse boardResponse = boardMapper.toResponse(board);

        // Sort column order ids
        List<String> columnOrderIds = sortedColumnIds(board.getColumnOrders());
        log.info("Column order ids: {}", columnOrderIds);


        List<BoardColumnResponse> columns = boardColumnRepository.findAllByBoardId(id).stream()
                .map(boardColumn -> {
                    BoardColumnResponse boardColumnResponse = new BoardColumnResponse();
                    boardColumnResponse.setId(boardColumn.getId());
                    boardColumnResponse.setTitle(boardColumn.getTitle());
                    boardColumnResponse.setBoardId(boardColumn.getBoard().getId());
                    boardColumnResponse.setCardOrderIds(sortedCardIds(boardColumn.getCardOrders()));
                    boardColumnResponse.setCards(getCardsByColumnId(boardColumn.getId(), boardColumn.getBoard().getId()));
                    return boardColumnResponse;
                })
                .toList();

        //Add columns to board response
        boardResponse.setColumns(columns);

        //Add column order ids to board response
        boardResponse.setColumnOrderIds(columnOrderIds);


        return boardResponse; // Return board detail
    }

    @Override
    public BoardResponse updateBoard(String id, BoardRequestDto request) {
        // Logic to update a board
        return null; // Return updated board
    }

    @Override
    public void deleteBoard(String id) {
        // Logic to delete a board
        boardRepository.deleteById(id);
    }
}