package com.example.emlakburada.gateway.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.emlakburada.gateway.dto.AdvertDTO;

import java.util.List;

@FeignClient(name = "advertClient", url = "http://localhost:8081/adverts")
public interface AdvertClient {

    @GetMapping
    List<AdvertDTO> getAllList();

    @PostMapping
    AdvertDTO create(@RequestBody AdvertDTO advertDTO);
    
    @PutMapping
    AdvertDTO update(@RequestBody AdvertDTO advertDTO);

    @GetMapping( "/{advertNo}")
    AdvertDTO getAdvertByAdvertNo(@PathVariable Long advertNo);
    
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);


}
