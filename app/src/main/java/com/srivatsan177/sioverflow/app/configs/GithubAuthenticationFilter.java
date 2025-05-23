package com.srivatsan177.sioverflow.app.configs;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.srivatsan177.sioverflow.app.clients.GithubApiRestClient;
import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;
import com.srivatsan177.sioverflow.app.dtos.github.GithubApiUserResponseDTO;
import com.srivatsan177.sioverflow.app.mappers.AppUserMapper;
import com.srivatsan177.sioverflow.app.services.AppUserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class GithubAuthenticationFilter extends OncePerRequestFilter {
    private final GithubApiRestClient githubApiRestClient;
    private final AppUserService appUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String accessToken = header.substring(7);
        GithubApiUserResponseDTO githubUser = githubApiRestClient.getUser(accessToken);
        AppUserDTO appUserDTO = AppUserMapper.toAppUserDTO(githubUser);
        appUserDTO = appUserService.findOrCreateUser(appUserDTO);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(appUserDTO.getUsername(),
                accessToken, List.of(appUserDTO.getRole()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}
