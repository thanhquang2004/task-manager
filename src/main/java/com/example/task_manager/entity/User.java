package com.example.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(unique = true)
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
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "boardId")
    )
    List<Board> boards;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "card_members",
                    joinColumns = @JoinColumn(name = "userId"),
                    inverseJoinColumns = @JoinColumn(name = "cardId")
            )
    Set<Card> cards;

    boolean isActive;
    String verifyToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
