package com.example.emlakburada.gateway.controller;

import com.example.emlakburada.gateway.dto.AdvertDTO;
import com.example.emlakburada.gateway.service.AdvertClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adverts")
public class AdvertController {

    @Autowired
    private AdvertClient advertClient;

    @GetMapping
    List<AdvertDTO> getAllList(){
        return advertClient.getAllList();
    }

    @PostMapping
    AdvertDTO create(@RequestBody AdvertDTO advertDTO){
        return advertClient.create(advertDTO);
    }
    @PutMapping
    AdvertDTO update(@RequestBody AdvertDTO advertDTO){
        return advertClient.update(advertDTO);
    }

    @GetMapping("/{advertNo}")
    AdvertDTO getAdvertByAdvertNo(@PathVariable Long advertNo){
       return advertClient.getAdvertByAdvertNo(advertNo);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        advertClient.delete(id);
    }


}
