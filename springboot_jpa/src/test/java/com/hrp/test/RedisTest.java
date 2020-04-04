package com.hrp.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 22:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRedis() throws JsonProcessingException {
        //从redis中获取数据，数据形式，json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        //判断redis中是否存在数据
        if(null == userListJson){
            //如果不存在，那么从数据库中查询
            List<User> list = userDao.findAll();
            //将list集合转换为json字符串
            userListJson = objectMapper.writeValueAsString(list);
            //将数据存入redis数据库中
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("=====这是从数据库中查询的数据=====");
        }else {
            System.out.println("=====这是从Redis缓存中查询的数据=====");
        }
        //存在，直接在控制台打印
        System.out.println(userListJson);
    }

}
