package com.example.emlak_burada_auth.service;


import com.example.emlakburada.auth.dto.AuthRequest;
import com.example.emlakburada.auth.dto.AuthResponse;
import com.example.emlakburada.auth.model.User;
import com.example.emlakburada.auth.repository.AuthRepository;
import com.example.emlakburada.auth.service.AuthService;
import com.example.emlakburada.auth.util.JwtUtil;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.time.ZonedDateTime;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Mock
    private JwtUtil jwtUtil;

    private User prepareMockUser(){
        User user = new User();
        user.setId(1L);
        user.setEmail("ozturkk.halimee@gmail.com");
        user.setPassword("12345");
        user.setCreatDate(ZonedDateTime.now());
        user.setUpdateDate(ZonedDateTime.now());
        return user;
    }

    private AuthRequest prepareMockAuthRequest(){
        AuthRequest user = new AuthRequest();
        user.setId(1L);
        user.setEmail("ozturkk.halimee@gmail.com");
        user.setPassword("12345");
        user.setCreatDate(ZonedDateTime.now());
        user.setCreatDate(ZonedDateTime.now());
        return user;
    }

    private AuthResponse prepareMockAuthResponse(){
        AuthResponse user = new AuthResponse();
        user.setToken("CREATEDTOKEN");
        return user;
    }


    @Test
    void getToken() throws Exception {
        Mockito.when(authRepository.findByEmail(any())).thenReturn(prepareMockUser());
        Mockito.when(jwtUtil.generateToken(any())).thenReturn("CREATEDTOKEN");
        AuthResponse authResponse = authService.getToken(prepareMockAuthRequest());
        assertEquals("CREATEDTOKEN",authResponse.getToken());
    }

}
