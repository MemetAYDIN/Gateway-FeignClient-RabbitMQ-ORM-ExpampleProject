package com.example.emlakburada.mapper;



import com.example.emlakburada.dto.ImageDTO;
import com.example.emlakburada.model.Image;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper<Image, ImageDTO>{
}
