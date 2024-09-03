package com.joaovictor.communicationmq.config.rabbitmq;

import com.joaovictor.communicationmq.config.constants.RabbitMQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultQueueConfig {

    @Bean
    DirectExchange defaultExchange() {
        return new DirectExchange(RabbitMQConstants.DEFAULT_EXCHANGE);
    }

    @Bean
    Queue defaultQueue() {
        return QueueBuilder.durable(RabbitMQConstants.DEFAULT_QUEUE).build();
    }

    @Bean
    Binding defaultBinding() {
        return BindingBuilder
              .bind(defaultQueue())
              .to(defaultExchange())
              .with(RabbitMQConstants.DEFAULT_ROUTING_KEY);
    }
}
