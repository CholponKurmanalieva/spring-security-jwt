package com.example.springsecurityjwt.mapper.base;

import java.util.List;

public interface BaseMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO DTO);
    DTO toDTO(ENTITY ENTITY);
    List<ENTITY> toEntities(List<DTO> dtos);
    List<DTO> toDTOs(List<ENTITY> entities);
}