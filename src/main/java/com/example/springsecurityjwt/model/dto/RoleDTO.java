package com.example.springsecurityjwt.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDTO {
    UUID id;
    String name;
    List<PermissionDTO> permissionDTOs;
}