package com.amqp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hrp
 * 2020/3/24 16:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AmqpTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test() {
        String message = "Hello World!";
        amqpTemplate.convertAndSend("amq.topic","insert",message);
    }
}
