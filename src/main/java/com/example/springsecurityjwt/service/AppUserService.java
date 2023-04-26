package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.model.dto.AppUserDTO;
import com.example.springsecurityjwt.model.request.AppUserCreateRequest;

import java.util.List;

public interface AppUserService {
    AppUserDTO create(AppUserCreateRequest request);
    List<AppUserDTO> getAll();
}