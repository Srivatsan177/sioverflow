package com.srivatsan177.sioverflow.app.dtos.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiUserResponse {
    private String login;
    private String email;
    @JsonProperty("avatar_url")
    private String avatarUrl;
}
