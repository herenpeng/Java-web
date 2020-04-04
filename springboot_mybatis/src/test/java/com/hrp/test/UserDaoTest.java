package com.hrp.test;

import com.hrp.MyApplication;
import com.hrp.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hrp
 * @date 2020/2/7 22:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;


}
