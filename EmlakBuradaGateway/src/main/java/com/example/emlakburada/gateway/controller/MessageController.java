package com.example.emlakburada.gateway.controller;


import com.example.emlakburada.gateway.dto.MessageDTO;
import com.example.emlakburada.gateway.service.MessageClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageClient messageClient;

    @GetMapping
    List<MessageDTO> getAllList(){
        return messageClient.getAllList();
    }

    @PostMapping
    MessageDTO create(@RequestBody MessageDTO messageDTO){
        return messageClient.create(messageDTO);
    }

    @GetMapping("/{id}")
    MessageDTO getMessageById(@PathVariable Long id){
        return messageClient.getMessageById(id);
    }

    @PutMapping
    MessageDTO update(@RequestBody MessageDTO messageDTO){
        return messageClient.update(messageDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        messageClient.delete(id);
    }
}
