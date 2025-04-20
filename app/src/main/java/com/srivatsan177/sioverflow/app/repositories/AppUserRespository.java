package com.srivatsan177.sioverflow.app.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srivatsan177.sioverflow.app.entities.AppUser;

public interface AppUserRespository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findByUsername(String username);
}
