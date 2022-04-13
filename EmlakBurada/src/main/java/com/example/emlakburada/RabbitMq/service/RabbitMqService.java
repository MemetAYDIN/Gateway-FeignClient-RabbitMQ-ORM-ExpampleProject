package com.example.emlakburada.RabbitMq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlakburada.Queue.config.RabbitMqConfig;
import com.example.emlakburada.service.EmailMessage;

@Service
public class RabbitMqService implements QueueService{
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private RabbitMqConfig config;

	@Override
	public void sendMessage(String string) {
		rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), string);

	}

	@Override
	public void sendMessage(EmailMessage email) {
		rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), email);
		
	}
}
