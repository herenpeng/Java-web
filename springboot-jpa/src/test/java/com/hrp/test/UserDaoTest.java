package com.hrp.test;

import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 22:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

}
