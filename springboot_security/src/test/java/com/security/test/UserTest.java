package com.security.test;

import com.security.dao.UserDao;
import com.security.domain.User;
import com.security.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hrp
 * 2020/3/29 16:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = userDao.selectById(1);
        System.out.println(user);
    }


    @Test
    public void test02(){
        try {
            System.out.println("try");
            int i = 1/0;
        }catch (Exception e){
            System.out.println("catch");
            return;
        }finally {
            System.out.println("finally");
        }
        System.out.println("test");
    }


}
