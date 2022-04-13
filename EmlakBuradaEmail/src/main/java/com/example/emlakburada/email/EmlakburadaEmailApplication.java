package com.example.emlakburada.email;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class EmlakburadaEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmlakburadaEmailApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("emlakburada.queue");
    }
}
