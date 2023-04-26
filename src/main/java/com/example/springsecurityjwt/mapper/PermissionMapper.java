package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.mapper.base.BaseMapper;
import com.example.springsecurityjwt.mapper.base.MapperConfiguration;
import com.example.springsecurityjwt.model.dto.PermissionDTO;
import com.example.springsecurityjwt.model.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface PermissionMapper extends BaseMapper<Permission, PermissionDTO> {
}