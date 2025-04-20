package com.srivatsan177.sioverflow.app.dtos;

import java.util.UUID;

import com.srivatsan177.sioverflow.app.entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserDTO {
    private UUID id;
    private String username;
    private String email;
    private UserRole role;
}