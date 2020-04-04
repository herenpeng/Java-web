package com.amqp.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hrp
 * 2020/3/24 16:21
 */
@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic_exchange_queue_1", durable = "false"),
            exchange = @Exchange(
                    value = "amq.topic",
                    ignoreDeclarationExceptions = "true",
                    durable = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"insert"}))
    public void listen(String message){
        System.out.println("接收到消息：" + message);
    }
}
