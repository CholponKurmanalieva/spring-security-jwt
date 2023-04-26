package com.example.springsecurityjwt.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserDTO {
    UUID id;
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    RoleDTO roleDTO;
}