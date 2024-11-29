package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "column_orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColumnOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    int position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "columnId")
    BoardColumn column;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardId")
    Board board;
}
