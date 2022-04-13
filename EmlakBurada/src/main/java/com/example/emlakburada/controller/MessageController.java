package com.example.emlakburada.controller;


import com.example.emlakburada.dto.MessageDTO;
import com.example.emlakburada.service.MessageService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    ResponseEntity<List<MessageDTO>> getAllList(){
        return ResponseEntity.ok(messageService.getAllList());
    }

    @PostMapping
    ResponseEntity<MessageDTO> create(@RequestBody MessageDTO messageDTO){
        return ResponseEntity.ok(messageService.create(messageDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<MessageDTO> getMessageById(@PathVariable Long id){
        return ResponseEntity.ok(messageService.getMessageById(id));
    }

    @PutMapping
    ResponseEntity<MessageDTO> update(@RequestBody MessageDTO messageDTO){
        return ResponseEntity.ok(messageService.update(messageDTO));
    }

}
