package com.example.emlakburada.email.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendMail(String email) {
    	
    	log.info("Email: "+email.toString());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("emlakk.hepsii@gmail.com");
        message.setTo(email);
        message.setSubject("Project email");
        message.setText("You just need to belive to sucees");
        mailSender.send(message);
        
        log.info("Email Message: "+message.toString());
    }
}
