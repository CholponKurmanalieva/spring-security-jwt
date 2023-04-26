package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.model.dto.RoleDTO;
import com.example.springsecurityjwt.model.request.RoleCreateRequest;

import java.util.List;

public interface RoleService {
    RoleDTO create(RoleCreateRequest request);
    List<RoleDTO> getAll();
}