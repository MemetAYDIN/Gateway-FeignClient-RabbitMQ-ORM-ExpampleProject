package com.example.emlakburada.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlakburada.email.dto.EmailDTO;
import com.example.emlakburada.email.repository.EmailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMqListenerService {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private final EmailRepository emailRepo;

	@RabbitListener(queues = "${emlakburada.rabbitmq.queue}")
	public void receiveMessage(EmailDTO message) throws AddressException, MessagingException {
		log.info(message.toString());
		emailService.sendMail(message.getSenderEmail());
		emailService.sendMail(message.getReceiverEmail());
	}
}
