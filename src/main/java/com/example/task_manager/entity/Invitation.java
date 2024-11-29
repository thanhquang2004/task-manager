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
public class Invitation extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String type;
    String status;
    boolean isDestroyed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardId")
    Board board;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inviterId")
    User inviter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inviteeId")
    User invitee;
}
