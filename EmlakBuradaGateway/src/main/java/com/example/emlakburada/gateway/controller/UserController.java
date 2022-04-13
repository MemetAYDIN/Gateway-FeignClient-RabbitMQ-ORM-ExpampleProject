package com.example.emlakburada.gateway.controller;

import com.example.emlakburada.gateway.dto.UserDTO;
import com.example.emlakburada.gateway.service.UserClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping
    List<UserDTO> getAllList(){
        return userClient.getAllList();
    }

    @PostMapping
    UserDTO create(@RequestBody UserDTO userDTO){
        return userClient.create(userDTO);
    }

    @PutMapping
    UserDTO update(@RequestBody UserDTO userDTO){
        return userClient.update(userDTO);
    }

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id){
        return userClient.getUserById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        userClient.delete(id);
    }
}
