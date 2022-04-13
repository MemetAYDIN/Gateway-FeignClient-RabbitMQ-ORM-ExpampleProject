package com.example.emlakburada.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import com.example.emlakburada.dto.UserDTO;
import com.example.emlakburada.mapper.UserMapper;
import com.example.emlakburada.model.User;
import com.example.emlakburada.repository.UserRepository;
import com.example.emlakburada.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.ZonedDateTime;


@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setup() {
        Mockito
         .when(userRepository.findAll())
         .thenReturn(prepareTestUserList());
        Mockito
          .when(userMapper.convertToDTOList(any()))
          .thenReturn(prepareTestUserDTOList());
        Mockito
          .when(userMapper.convertToDTO(any()))
          .thenReturn(prepareTestUserDTO());
        Mockito
          .when(userMapper.convertToEntity(any()))
          .thenReturn(prepareTestUser());

    }

    
    @Test
    void getAllUserTest() {
        List<UserDTO> allUser = userService.getAllList();
        assertNotNull(allUser);
        assertThat(allUser.size()).isNotZero();
    }

    @Test
    void create(){
        Mockito.when(userRepository.save(any())).thenReturn(prepareTestUser());
        UserDTO user = userService.create(prepareTestUserDTO());
        assertEquals(user.getId(), 1L);
    }

    @Test
    void getUserById(){
        Mockito.when(userRepository.findById(any())).thenReturn(java.util.Optional.of(prepareTestUser()));
        UserDTO userDTO = userService.getUserById(any());
        assertEquals(userDTO.getId(),1L);
    }

    @Test
    void update(){
        Mockito.when(userRepository.save(any())).thenReturn(prepareTestUser());
        Mockito.when(userRepository.findById(any())).thenReturn(java.util.Optional.of(prepareTestUser()));
        UserDTO user = userService.update(prepareTestUserDTO());
        assertEquals(user.getId(), 1L);
    }

    private List<User> prepareTestUserList() {
        List<User> users = new ArrayList<>();
        users.add(prepareTestUser());
        return users;
    }

    private User prepareTestUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Mehmet");
        user.setSurname("AYDIN");
        user.setEmail("mehmet.aydin.bsnss@gmail.com");
        return user;
    }

    private List<UserDTO> prepareTestUserDTOList() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(prepareTestUserDTO());
        return userDTOS;
    }

    private UserDTO prepareTestUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("Mehmet");
        userDTO.setSurname("AYDIN");
        userDTO.setEmail("mehmet.aydin.bsnss@gmail.com");

        return userDTO;
    }

}
