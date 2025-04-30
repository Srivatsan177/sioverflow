package com.srivatsan177.sioverflow.app.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.srivatsan177.sioverflow.app.common.RestConstants;
import com.srivatsan177.sioverflow.app.dtos.github.GithubApiUserResponseDTO;

@Component
public class GithubApiRestClient extends AppRestClient {
    public GithubApiRestClient(@Value("${github.api-host}") String baseUrl) {
        super(baseUrl);
    }

    public GithubApiUserResponseDTO getUser(String accessToken) {
        return get(RestConstants.GITHUB_USER, null, headers -> headers.setBearerAuth(accessToken),
                GithubApiUserResponseDTO.class);
    };
}
