package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Data
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String title;
    String description;
    String cover;
    public boolean isDestroyed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "columnId")
    BoardColumn column;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardId")
    Board board;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "card_members",
            joinColumns = @JoinColumn(name = "cardId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    Set<User> members;

}