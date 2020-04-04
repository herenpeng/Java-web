package com.hrp.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author hrp
 * 2020/3/31 11:36
 */
@Component
public class MyListener2 implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("MyListener2收到消息："+message);
        System.out.println("Mylistener2:"+new String(pattern));
    }
}
