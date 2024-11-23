package com.example.task_manager.controller;

import com.example.task_manager.dto.request.CardRequestDto;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.dto.response.ApiResponse;
import com.example.task_manager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<ApiResponse<CardResponse>> createCard(@RequestBody CardRequestDto cardRequest) {
        CardResponse cardResponse = cardService.createCard(cardRequest);

        ApiResponse<CardResponse> apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(), "Card created successfully", cardResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CardResponse>> getCardById(@PathVariable String id) {
        CardResponse cardResponse = cardService.getCardById(id);
        ApiResponse<CardResponse> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Card fetched successfully", cardResponse);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CardResponse>> updateCard(@PathVariable String id, @RequestBody CardRequestDto cardRequest) {
        CardResponse cardResponse = cardService.updateCard(id, cardRequest);
        ApiResponse<CardResponse> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Card updated successfully", cardResponse);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCard(@PathVariable String id) {
        cardService.deleteCard(id);
        ApiResponse<Void> apiResponse = new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Card deleted successfully", null);
        return ResponseEntity.noContent().build();
    }
}
