package com.srivatsan177.sioverflow.app.dtos.auth.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubToken {
    private String accessToken;
}
