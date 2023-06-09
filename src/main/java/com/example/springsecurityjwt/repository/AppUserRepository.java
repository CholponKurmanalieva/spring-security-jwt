package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    boolean existsByUsername(String username);
    Optional<AppUser> findByUsername(String username);
}