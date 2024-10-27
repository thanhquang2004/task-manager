package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String email;
    String password;
    @Column(unique = true)
    String username;
    String displayName;
    String avatar;

    @ManyToOne(fetch = FetchType.EAGER)
    Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "board_members",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")
    )
    List<Board> boards;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "card_members",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "card_id")
            )
    Set<Card> cards;

    boolean isActive;
    String verifyToken;
}
