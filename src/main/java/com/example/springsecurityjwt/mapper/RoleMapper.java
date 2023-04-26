package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.mapper.base.BaseMapper;
import com.example.springsecurityjwt.mapper.base.MapperConfiguration;
import com.example.springsecurityjwt.model.dto.RoleDTO;
import com.example.springsecurityjwt.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, uses = PermissionMapper.class)
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {
    @Override
    @Mapping(target = "permissions", source = "permissionDTOs")
    Role toEntity(RoleDTO DTO);

    @Override
    @Mapping(target = "permissionDTOs", source = "permissions")
    RoleDTO toDTO(Role ENTITY);
}