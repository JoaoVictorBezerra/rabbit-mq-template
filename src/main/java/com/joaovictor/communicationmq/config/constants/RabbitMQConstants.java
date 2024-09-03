package com.joaovictor.communicationmq.config.constants;



public class RabbitMQConstants {
    private RabbitMQConstants() {
        throw new IllegalArgumentException("This is an utility class!");
    }

    public static final String DEFAULT_QUEUE = "${rabbit.mq.queue.default}";

    public static final String DEFAULT_EXCHANGE = "${rabbit.mq.exchange.default}";

    public static final String DEFAULT_ROUTING_KEY = "${rabbit.mq.routing.key.default}";
}
