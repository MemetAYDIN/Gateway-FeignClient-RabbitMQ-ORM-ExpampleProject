package com.example.emlakburada.mapper;


import com.example.emlakburada.dto.CategoryDTO;
import com.example.emlakburada.model.Category;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO>{
}
