package com.clientsapi.clients.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class producerConfig {

    @Value("cola_clientes_movimientos")
    private String message;

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }
}
