package com.example.emlakburada.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.emlakburada.gateway.dto.BannerDTO;

import java.util.List;

@FeignClient(name = "bannerClient", url = "http://localhost:8082/banners")
public interface BannerClient {

    @GetMapping
    List<BannerDTO> getAllList();

    @PostMapping
    BannerDTO create(@RequestBody BannerDTO bannerDTO);
    @PutMapping
    BannerDTO update(@RequestBody BannerDTO bannerDTO);

    @GetMapping("/{id}")
    BannerDTO getById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

   
}
