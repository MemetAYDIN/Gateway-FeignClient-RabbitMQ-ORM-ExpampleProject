package com.example.emlakburada.banner.mapper;



import com.example.emlakburada.banner.dto.BaseEntityDTO;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface Map<Entity , DTO > {

    @Named("convertToEntity")
    @Mapping(target = "creationDate", ignore = true)
    Entity convertToEntity(DTO dto);

    @Named("convertToDTO")
    DTO convertToDTO(Entity entity);

    @IterableMapping(qualifiedByName = "convertToEntityList")
    List<Entity> convertToEntityList(List<DTO> dtoList);

    @IterableMapping(qualifiedByName = "convertToDTOList")
    List<DTO> convertToDTOList(List<Entity> entityList);


}
