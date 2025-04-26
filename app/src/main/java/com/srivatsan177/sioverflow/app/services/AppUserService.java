package com.srivatsan177.sioverflow.app.services;

import org.springframework.stereotype.Service;

import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;

@Service
public interface AppUserService {
    AppUserDTO findOrCreateUser(AppUserDTO appUserDTO);

    AppUserDTO findUser(String username);
}
