package com.joaovictor.communicationmq.config.constants;



public class RabbitMQConstants {
    private RabbitMQConstants() {
        throw new IllegalArgumentException("This is an utility class!");
    }

//    @Value("${rabbit.mq.queue.default}")
    public static String DEFAULT_QUEUE = "default-queue";

//    @Value("${rabbit.mq.exchange.default}")
    public static String DEFAULT_EXCHANGE = "exchange-default";

//    @Value("${rabbit.mq.routing.key.default}")
    public static String DEFAULT_ROUTING_KEY = "default-routing-key";
}
