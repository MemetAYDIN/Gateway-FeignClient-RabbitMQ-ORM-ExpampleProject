package com.example.emlakburada.service;


import com.example.emlakburada.dto.CategoryDTO;
import com.example.emlakburada.exception.ServiceException;
import com.example.emlakburada.mapper.CategoryMapper;
import com.example.emlakburada.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllList() {
        return categoryMapper.convertToDTOList(categoryRepository.findAll());
    }

    @Transactional
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return categoryMapper.convertToDTO(categoryRepository.save(categoryMapper.convertToEntity(categoryDTO)));
    }

    @Transactional
    public CategoryDTO update(CategoryDTO categoryDTO) {
        getById(categoryDTO.getId());
        return categoryMapper.convertToDTO(categoryRepository.save(categoryMapper.convertToEntity(categoryDTO)));
    }

    public CategoryDTO getById(Long id){
        return categoryMapper.convertToDTO(categoryRepository.findById(id).orElseThrow(() -> new ServiceException(ServiceException.NOT_FOUND,"Category not found")));
    }
}
