package com.joaovictor.communicationmq.receiver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class DefaultReceiver {
    @RabbitListener(bindings = @QueueBinding(
          value = @Queue(value = "default-queue"),
          exchange = @Exchange(name = "default-exchange"),
          key = "default-routing-key")
    )
    public void process(Message message) throws UnsupportedEncodingException {
        String messageToShow = new String(message.getBody(), "UTF-8");  // Converte o array de bytes para String
        System.out.println(messageToShow);
//        log.info("Routing key {}", message.getMessageProperties().getPriority());
//        log.info("Finish with message {}", message.getBody());
    }
}
