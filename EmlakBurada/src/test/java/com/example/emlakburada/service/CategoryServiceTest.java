package com.example.emlakburada.service;

import com.example.emlakburada.dto.CategoryDTO;
import com.example.emlakburada.mapper.CategoryMapper;
import com.example.emlakburada.model.Category;
import com.example.emlakburada.repository.CategoryRepository;
import com.example.emlakburada.service.CategoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CategoryServiceTest {
    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;

    @BeforeEach
    void setup(){
        Mockito
         .when(categoryRepository.findAll())
         .thenReturn(prepareMockCategoryList());
        Mockito
         .when(categoryMapper.convertToDTOList(any()))
         .thenReturn(prepareMockCategoryDTOList());
        Mockito
         .when(categoryMapper.convertToDTO(any()))
         .thenReturn(prepareMockCategoryDTO());
        Mockito
         .when(categoryMapper.convertToEntity(any()))
         .thenReturn(prepareMockCategory());
    }

    private List<Category> prepareMockCategoryList(){
        List<Category> categories = new ArrayList<>();
        categories.add(prepareMockCategory());
        return categories;
    }

    private Category prepareMockCategory(){
        Category category = new Category();
        category.setId(1L);
        category.setName("test");
        return category;
    }

    private List<CategoryDTO> prepareMockCategoryDTOList(){
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryDTOS.add(prepareMockCategoryDTO());
        return categoryDTOS;
    }

    private CategoryDTO prepareMockCategoryDTO(){
        CategoryDTO category = new CategoryDTO();
        category.setId(1L);
        category.setName("test");
        return category;
    }


    @Test
    void getAllUserTest() {
        List<CategoryDTO> allCategory = categoryService.getAllList();
        assertNotNull(allCategory);
        assertThat(allCategory.size()).isNotZero();
    }

    @Test
    void create(){
        Mockito.when(categoryRepository.save(any())).thenReturn(prepareMockCategory());
        CategoryDTO categoryDTO = categoryService.create(prepareMockCategoryDTO());
        assertEquals(categoryDTO.getId(), 1L);
    }

    @Test
    void getUserById(){
        Mockito.when(categoryRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockCategory()));
        CategoryDTO categoryDTO = categoryService.getById(any());
        assertEquals(categoryDTO.getId(),1L);
    }

    @Test
    void update(){
        Mockito.when(categoryRepository.save(any())).thenReturn(prepareMockCategory());
        Mockito.when(categoryRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockCategory()));
        CategoryDTO categoryDTO = categoryService.update(prepareMockCategoryDTO());
        assertEquals(categoryDTO.getId(), 1L);
    }
}
