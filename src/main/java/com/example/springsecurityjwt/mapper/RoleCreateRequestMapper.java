package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.mapper.base.BaseMapper;
import com.example.springsecurityjwt.mapper.base.MapperConfiguration;
import com.example.springsecurityjwt.model.entity.Role;
import com.example.springsecurityjwt.model.request.RoleCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface RoleCreateRequestMapper extends BaseMapper<Role, RoleCreateRequest> {
    @Override
    @Mapping(target = "permissions", ignore = true)
    Role toEntity(RoleCreateRequest DTO);
}
