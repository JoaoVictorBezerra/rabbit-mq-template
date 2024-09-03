package com.joaovictor.communicationmq.receiver;


import com.joaovictor.communicationmq.config.constants.RabbitMQConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Component
public class DefaultReceiver {
    Logger logger = Logger.getLogger(getClass().getName());
    @RabbitListener(bindings = @QueueBinding(
          value = @Queue(value = RabbitMQConstants.DEFAULT_QUEUE),
          exchange = @Exchange(name = RabbitMQConstants.DEFAULT_EXCHANGE),
          key = RabbitMQConstants.DEFAULT_ROUTING_KEY)
    )
    public void process(Message message) {
        try {
            logger.info("QUEUE Default Listener::");
            String messageToShow = new String(message.getBody(), StandardCharsets.UTF_8);  // Converte o array de bytes para String
            logger.info("MESSAGE:: " + messageToShow);
        } catch (Exception e) {
            logger.severe("ERROR:: " + e.getMessage());
        }
    }
}
