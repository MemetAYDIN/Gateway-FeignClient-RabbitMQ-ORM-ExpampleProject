package com.example.emlakburada.controller;

import com.example.emlakburada.dto.AdvertDTO;
import com.example.emlakburada.service.AdvertService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adverts")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @GetMapping
    ResponseEntity<List<AdvertDTO>> getAllList(){
        return ResponseEntity.ok(advertService.getAllList());
    }

    @PostMapping
    ResponseEntity<AdvertDTO> create(@RequestBody AdvertDTO advertDTO){
        return ResponseEntity.ok(advertService.create(advertDTO));
    }

    @PutMapping
    ResponseEntity<AdvertDTO> update(@RequestBody AdvertDTO advertDTO){
        return ResponseEntity.ok(advertService.update(advertDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<AdvertDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(advertService.getById(id));
    }
}
