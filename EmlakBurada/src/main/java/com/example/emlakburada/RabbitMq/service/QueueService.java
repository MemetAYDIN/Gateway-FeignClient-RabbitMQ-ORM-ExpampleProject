package com.example.emlakburada.RabbitMq.service;

import com.example.emlakburada.service.EmailMessage;

public interface QueueService {

	void sendMessage(EmailMessage email);

	void sendMessage(String string);
}
