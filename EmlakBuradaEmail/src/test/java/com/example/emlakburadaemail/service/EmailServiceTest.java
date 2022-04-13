package com.example.emlakburadaemail.service;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.emlakburada.email.service.EmailService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class EmailServiceTest {
    @InjectMocks
    private EmailService emailService;
    @Mock
    private JavaMailSender mailSender;

    @Mock
    private SimpleMailMessage emailCaptor;

    @Test
    void sendMail(){
//        ArgumentCaptor<SimpleMailMessage> emailCaptor = ArgumentCaptor.forClass(SimpleMailMessage .class);
        Mockito.when(emailCaptor.getFrom()).thenReturn("emlakk.hepsii@gmail.com");
        Mockito.when(emailCaptor.getTo()).thenReturn(new String[]{"test@mailinator.com"});
        Mockito.when(emailCaptor.getSubject()).thenReturn("Time never comes again.");
        Mockito.when(emailCaptor.getSubject()).thenReturn("Do it today, or regret it tomorrow.");

        doNothing().when(mailSender).send((SimpleMailMessage) any());
        emailService.sendMail("test@mailinator.com");
        verify(mailSender).send((SimpleMailMessage) any());
    }

}
