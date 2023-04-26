package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.mapper.RoleCreateRequestMapper;
import com.example.springsecurityjwt.mapper.RoleMapper;
import com.example.springsecurityjwt.model.dto.RoleDTO;
import com.example.springsecurityjwt.model.entity.Permission;
import com.example.springsecurityjwt.model.entity.Role;
import com.example.springsecurityjwt.model.request.RoleCreateRequest;
import com.example.springsecurityjwt.repository.PermissionRepository;
import com.example.springsecurityjwt.repository.RoleRepository;
import com.example.springsecurityjwt.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RoleCreateRequestMapper roleCreateRequestMapper;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO create(RoleCreateRequest request) {
        log.info("Role {} is creating ", request.getName());
        List<Permission> permissions = permissionRepository.findAllById(request.getPermissionIds());

        Role role = roleCreateRequestMapper.toEntity(request);
        role.setName("ROLE_" + role.getName().toUpperCase());
        role.setPermissions(permissions);

        return roleMapper.toDTO(roleRepository.save(role));
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleMapper.toDTOs(roleRepository.findAll());
    }
}