package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.CardRequestDto;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.*;
import com.example.task_manager.exception.CardNotFoundException;
import com.example.task_manager.mapper.CardMapper;
import com.example.task_manager.mapper.UserMapper;
import com.example.task_manager.repository.*;
import com.example.task_manager.service.CardService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CardServiceImpl implements CardService {
    UserRepository userRepository;
    CardRepository cardRepository;
    BoardColumnRepository boardColumnRepository;
    BoardRepository boardRepository;
    CardOrderRepository cardOrderRepository;

    CardMapper cardMapper;
    UserMapper userMapper;


    UserResponse getCurrentUser() {
        // Logic to get current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("credentials: {}", authentication);
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toUserResponse(user); // Return current user
    }

    @Override
    public CardResponse createCard(CardRequestDto cardRequest) {

        BoardColumn column = boardColumnRepository.findById(cardRequest.getColumnId())
                .orElseThrow(() -> new CardNotFoundException("Column not found"));
        Board board = boardRepository.findById(cardRequest.getBoardId())
                .orElseThrow(() -> new CardNotFoundException("Board not found"));

        List<CardOrder> columnOrders = column.getCardOrders();
        Integer maxPosition = columnOrders.stream().map(CardOrder::getPosition).max(Integer::compareTo).orElse(0);

        Card card = cardMapper.toEntity(cardRequest);
        card.setColumn(column);
        card.setBoard(board);


        Card newCard = cardRepository.save(card);

        CardOrder cardOrder = CardOrder.builder()
                .position(maxPosition + 1)
                .boardColumn(column)
                .card(newCard)
                .build();
//        log.info("columnOrder: {}", columnOrder);
        cardOrderRepository.save(cardOrder);
        CardResponse response = cardMapper.toResponse(newCard);
        response.setColumnId(newCard.getColumn().getId());
        response.setBoardId(newCard.getBoard().getId());

        return response;
    }

    @Override
    public CardResponse getCardById(String cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();
        return cardMapper.toResponse(card);
    }

    @Override
    public CardResponse updateCard(String cardId, CardRequestDto cardRequest) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();

        // Cập nhật các trường của card
        card.setTitle(cardRequest.getTitle());
        card.setDescription(cardRequest.getDescription());
        card.setCover(cardRequest.getCover());

        // Lưu lại và trả về phản hồi
        card = cardRepository.save(card);
        return cardMapper.toResponse(card);
    }

    @Override
    public void deleteCard(String cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();
        cardRepository.delete(card);

        CardOrder cardOrder = cardOrderRepository.findByCardId(cardId);
        cardOrderRepository.delete(cardOrder);
    }
}
