package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.mapper.base.BaseMapper;
import com.example.springsecurityjwt.mapper.base.MapperConfiguration;
import com.example.springsecurityjwt.model.dto.AppUserDTO;
import com.example.springsecurityjwt.model.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, uses = RoleMapper.class)
public interface AppUserMapper extends BaseMapper<AppUser, AppUserDTO> {
    @Override
    @Mapping(target = "role", source = "roleDTO")
    AppUser toEntity(AppUserDTO DTO);

    @Override
    @Mapping(target = "roleDTO", source = "role")
    AppUserDTO toDTO(AppUser ENTITY);
}