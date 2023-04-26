package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}