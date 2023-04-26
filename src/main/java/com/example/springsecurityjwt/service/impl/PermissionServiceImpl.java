package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.mapper.PermissionMapper;
import com.example.springsecurityjwt.model.dto.PermissionDTO;
import com.example.springsecurityjwt.model.entity.Permission;
import com.example.springsecurityjwt.repository.PermissionRepository;
import com.example.springsecurityjwt.service.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;
    @Override
    public PermissionDTO save(PermissionDTO permissionDTO) {
        log.info("Permission {} is creating ", permissionDTO);

        Permission permission = permissionMapper.toEntity(permissionDTO);
        permission.setAuthority(permissionDTO.getAuthority().toUpperCase());

        return permissionMapper.toDTO(permissionRepository.save(permission));
    }

    @Override
    public List<PermissionDTO> getAll() {
        return permissionMapper.toDTOs(permissionRepository.findAll());
    }
}
