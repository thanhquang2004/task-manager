package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "card_orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    int position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cardId")
    Card card;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardColumnId")
    BoardColumn boardColumn;
}
