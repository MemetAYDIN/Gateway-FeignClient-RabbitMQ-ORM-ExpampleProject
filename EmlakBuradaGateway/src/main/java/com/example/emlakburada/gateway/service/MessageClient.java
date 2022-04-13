package com.example.emlakburada.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.emlakburada.gateway.dto.MessageDTO;

import java.util.List;

@FeignClient(name = "messageClient", url = "http://localhost:8081/messages")
public interface MessageClient {

    @GetMapping
    List<MessageDTO> getAllList();

    @PostMapping
    MessageDTO create(@RequestBody MessageDTO messageDTO);
    
    @PutMapping
    MessageDTO update(@RequestBody MessageDTO messageDTO);

    @GetMapping("/{id}")
    MessageDTO getMessageById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

  
}
