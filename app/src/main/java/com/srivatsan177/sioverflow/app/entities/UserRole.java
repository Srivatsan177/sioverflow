package com.srivatsan177.sioverflow.app.entities;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
