package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "card_attachments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardAttachment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String filename;
    String fileType;
    String fileUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    Card card;
}
