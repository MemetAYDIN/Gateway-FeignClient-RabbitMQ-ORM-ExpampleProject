package com.example.emlakburada.email.service;

import com.example.emlakburada.email.model.Email;
import com.example.emlakburada.email.repository.EmailRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActiveMqListenerService {
    private final EmailService emailService;
    private final EmailRepository emailRepository;

    @JmsListener(destination = "emlakburada.queue")
    public void consume(String email) {
        emailService.sendMail(email);

        saveEmail(email);
        System.out.println("Received Message: " + email);
    }

    public void saveEmail(String email){
        Email email1 = new Email();
        email1.setReceiverEmail(email);
        email1.setSenderEmail("emlakk.hepsii@gmail.com");
        emailRepository.save(email1);
    }

}
