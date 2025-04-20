package com.srivatsan177.sioverflow.app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    @GetMapping
    public String getMethodName(Authentication authentication) {
        return authentication.getName();
    }
}
