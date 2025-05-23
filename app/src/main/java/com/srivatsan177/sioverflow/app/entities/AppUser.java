package com.srivatsan177.sioverflow.app.entities;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private UserRole role;
    private String avatarUrl;
}
