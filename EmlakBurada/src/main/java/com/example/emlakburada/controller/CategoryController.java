package com.example.emlakburada.controller;

import com.example.emlakburada.dto.CategoryDTO;
import com.example.emlakburada.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<CategoryDTO>> getAllList(){
        return ResponseEntity.ok(categoryService.getAllList());
    }

    @PostMapping
    ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.create(categoryDTO));
    }

    @PutMapping
    ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.update(categoryDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }
}
