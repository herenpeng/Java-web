package com.hrp.test;

import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void demo01(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
