package com.example.task_manager.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "boards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String title;

    @Column(columnDefinition = "text")
    String description;

    String type;

    boolean isDestroyed;

    @ManyToMany
    @JoinTable(
            name = "board_members",
            joinColumns = @JoinColumn(name = "boardId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    List<User> members;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<ColumnOrder> columnOrders;
}