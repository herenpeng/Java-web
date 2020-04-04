package com.hrp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hrp
 * 2020/3/30 21:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PubSubTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        stringRedisTemplate.convertAndSend("Mylistener1","Redis发布的第一条消息");
        stringRedisTemplate.convertAndSend("Mylistener2","Redis发布的第二条消息");
    }
}
