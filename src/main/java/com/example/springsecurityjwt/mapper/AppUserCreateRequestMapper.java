package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.mapper.base.BaseMapper;
import com.example.springsecurityjwt.mapper.base.MapperConfiguration;
import com.example.springsecurityjwt.model.entity.AppUser;
import com.example.springsecurityjwt.model.request.AppUserCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface AppUserCreateRequestMapper extends BaseMapper<AppUser, AppUserCreateRequest> {
    @Override
    @Mapping(target = "role", ignore = true)
    AppUser toEntity(AppUserCreateRequest DTO);
}