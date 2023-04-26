package com.example.springsecurityjwt.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserCreateRequest {
    @NotBlank
    String username;
    @Length(min = 8, max = 17)
    String password;
    String firstName;
    String lastName;
    String email;
    UUID roleId;
}