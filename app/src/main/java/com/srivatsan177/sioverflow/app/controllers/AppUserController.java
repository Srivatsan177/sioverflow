package com.srivatsan177.sioverflow.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;
import com.srivatsan177.sioverflow.app.services.AppUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/info")
    public AppUserDTO userInfo(Authentication authentication) {
        AppUserDTO user = appUserService.findUser(authentication.getName());
        log.info("User info fetched for: {}", authentication.getName());
        return user;
    }

}
