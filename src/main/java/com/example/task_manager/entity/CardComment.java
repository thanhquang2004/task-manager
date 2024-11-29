package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "card_comments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cardId")
    Card card;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    User user;
}