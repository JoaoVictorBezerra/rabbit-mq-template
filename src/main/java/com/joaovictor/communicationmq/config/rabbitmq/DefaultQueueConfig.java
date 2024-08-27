package com.joaovictor.communicationmq.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultQueueConfig {

    @Bean
    DirectExchange defaultExchange() {
        return new DirectExchange("default-exchange");
    }

    @Bean
    Queue defaultQueue() {
        return QueueBuilder.durable("default-queue").build();
    }

    @Bean
    Binding defaultBinding() {
        return BindingBuilder
              .bind(defaultQueue())
              .to(defaultExchange())
              .with("default-routing-key");
    }
}
