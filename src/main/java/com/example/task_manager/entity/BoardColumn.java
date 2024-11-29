package com.example.task_manager.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "boardColumns")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardColumn extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    Board board;

    String title;

    @OneToMany(mappedBy = "boardColumn", fetch = FetchType.LAZY)
    List<CardOrder> cardOrders;

    boolean isDestroyed;

}