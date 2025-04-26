package com.srivatsan177.sioverflow.app.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;
import com.srivatsan177.sioverflow.app.entities.AppUser;
import com.srivatsan177.sioverflow.app.entities.UserRole;
import com.srivatsan177.sioverflow.app.exceptions.RestException;
import com.srivatsan177.sioverflow.app.mappers.AppUserMapper;
import com.srivatsan177.sioverflow.app.repositories.AppUserRespository;
import com.srivatsan177.sioverflow.app.services.AppUserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRespository appUserRespository;

    @Override
    @Transactional
    public AppUserDTO findOrCreateUser(AppUserDTO appUserDTO) {
        AppUser user = appUserRespository.findByUsername(appUserDTO.getUsername()).orElse(null);
        if (user == null) {
            user = AppUserMapper.toAppUser(appUserDTO);
            user.setRole(UserRole.USER);
            return AppUserMapper.toAppUserDTO(appUserRespository.save(user));
        }
        return AppUserMapper.toAppUserDTO(user);
    }

    @Override
    public AppUserDTO findUser(String username) {
        AppUser user = appUserRespository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "User not found"));
        return AppUserMapper.toAppUserDTO(user);
    }

}
