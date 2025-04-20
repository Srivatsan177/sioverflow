package com.srivatsan177.sioverflow.app.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.srivatsan177.sioverflow.app.common.RestConstants;
import com.srivatsan177.sioverflow.app.dtos.github.GithubAuthorizeRequestDTO;
import com.srivatsan177.sioverflow.app.dtos.github.GithubAuthorizeResponseDTO;

@Component
public class GithubRestClient extends AppRestClient {
    @Value("${github.client-id}")
    private String clientId;

    @Value("${github.client-secret}")
    private String clientSecret;
    @Value("${github.redirect-uri}")
    private String redirectUri;

    public GithubRestClient(@Value("${github.host}") String baseUrl) {
        super(baseUrl);
    }

    public GithubAuthorizeResponseDTO getAccessToken(String code) {
        GithubAuthorizeRequestDTO requestBody = new GithubAuthorizeRequestDTO(
                code,
                clientId,
                clientSecret);
        return post(RestConstants.ACCESS_TOKEN, requestBody, GithubAuthorizeResponseDTO.class);
    }
}
