package com.example.emlakburada.mapper;


import com.example.emlakburada.dto.BaseEntityDTO;
import com.example.emlakburada.model.BaseEntity;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<Entity extends BaseEntity, DTO extends BaseEntityDTO> {

    @Named("toEntity")
    @Mapping(target = "creationDate", ignore = true)
    Entity convertToEntity(DTO dto);

    @Named("toDTO")
    DTO convertToDTO(Entity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Entity> convertToEntityList(List<DTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<DTO> convertToDTOList(List<Entity> entityList);


}
