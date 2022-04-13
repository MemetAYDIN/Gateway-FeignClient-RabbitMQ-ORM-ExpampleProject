package com.example.emlakburada.banner.controller;


import com.example.emlakburada.banner.dto.BannerDTO;
import com.example.emlakburada.banner.service.BannerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banners")
@RequiredArgsConstructor
public class BannerController {
    private final BannerService bannerService;

    @GetMapping
    ResponseEntity<List<BannerDTO>> getAllList(){
        return ResponseEntity.ok(bannerService.getAllList());
    }

    @PostMapping
    ResponseEntity<BannerDTO> create(@RequestBody BannerDTO advertDTO){
        return ResponseEntity.ok(bannerService.create(advertDTO));
    }


    @GetMapping("/{id}")
    ResponseEntity<BannerDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(bannerService.getById(id));
    }

    @PutMapping
    ResponseEntity<BannerDTO> update(@RequestBody BannerDTO bannerDTO){
        return ResponseEntity.ok(bannerService.update(bannerDTO));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        bannerService.delete(id);
    }
}
