package com.joaovictor.communicationmq.producer;

import com.joaovictor.communicationmq.config.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class DefaultProducer {
    private final AmqpTemplate rabbitTemplate;

    public DefaultProducer(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.DEFAULT_EXCHANGE, RabbitMQConstants.DEFAULT_ROUTING_KEY, message);
    }
}
