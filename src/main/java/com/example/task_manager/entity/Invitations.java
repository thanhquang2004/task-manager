package com.example.task_manager.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "invitations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invitations extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String type;
    String status;
    boolean isDestroyed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    Board board;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inviter_id")
    User inviter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invitee_id")
    User invitee;
}
