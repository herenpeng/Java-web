package com.hrp.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author hrp
 * 2020/3/30 21:35
 */
@Component
public class MyListener1 implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("MyListener1收到消息："+message);
        System.out.println("Mylistener1:"+new String(pattern));
    }
}
