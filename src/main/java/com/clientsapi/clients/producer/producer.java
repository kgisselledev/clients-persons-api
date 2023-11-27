package com.clientsapi.clients.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class producer {

    private final AmqpTemplate amqpTemplate;
    private static final Logger logger = LoggerFactory.getLogger(producer.class);

    @Autowired
    public producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message) {

        String queueName = "cola_clientes_movimientos";
        amqpTemplate.convertAndSend(queueName, message);
        logger.info("# Enviado '" + message + "' a la cola '" + queueName + "'");
    }

}

