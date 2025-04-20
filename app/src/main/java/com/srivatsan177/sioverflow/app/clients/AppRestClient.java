package com.srivatsan177.sioverflow.app.clients;

import java.util.function.Consumer;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

public class AppRestClient {
    private String baseUrl;
    private RestClient restClient;

    public AppRestClient(String baseUrl) {
        this.baseUrl = baseUrl;
        restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }

    private String getUri(String path, MultiValueMap<String, String> params) {
        String location = UriComponentsBuilder.fromUriString(path).queryParams(params).build().toString();
        return baseUrl + location;
    }

    public <T> T get(String path, MultiValueMap<String, String> params, Class<T> responseType) {
        return restClient.get().uri(getUri(path, params)).retrieve().body(responseType);
    }

    public <T> T get(String path, MultiValueMap<String, String> params, Consumer<HttpHeaders> headers,
            Class<T> responseType) {
        return restClient.get().uri(getUri(path, null)).headers(headers).retrieve().body(responseType);
    }

    public <T, B> T post(String path, B body, Class<T> responseType) {
        return restClient.post().uri(getUri(path, null)).body(body).retrieve().body(responseType);
    }
}
