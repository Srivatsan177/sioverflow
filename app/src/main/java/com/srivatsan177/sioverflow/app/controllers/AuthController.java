package com.srivatsan177.sioverflow.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srivatsan177.sioverflow.app.clients.GithubRestClient;
import com.srivatsan177.sioverflow.app.dtos.auth.github.GithubTokenDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final GithubRestClient githubRestClient;

    @GetMapping("/code/github")
    public GithubTokenDTO getGithubCode(@RequestParam String code) {
        return new GithubTokenDTO(githubRestClient.getAccessToken(code).getAccessToken());
    }
}
