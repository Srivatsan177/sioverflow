package com.srivatsan177.sioverflow.app.mappers;

import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;
import com.srivatsan177.sioverflow.app.dtos.github.GithubApiUserResponseDTO;
import com.srivatsan177.sioverflow.app.entities.AppUser;

public class AppUserMapper {
    public static AppUserDTO toAppUserDTO(AppUser user) {
        return AppUserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }

    public static AppUser toAppUser(AppUserDTO appUserDTO) {
        return AppUser.builder()
                .id(appUserDTO.getId())
                .username(appUserDTO.getUsername())
                .email(appUserDTO.getEmail())
                .role(appUserDTO.getRole())
                .avatarUrl(appUserDTO.getAvatarUrl())
                .build();
    }

    public static AppUserDTO toAppUserDTO(GithubApiUserResponseDTO githubUser) {
        return AppUserDTO.builder()
                .username(githubUser.getLogin())
                .email(githubUser.getEmail())
                .avatarUrl(githubUser.getAvatarUrl())
                .build();
    }
}
