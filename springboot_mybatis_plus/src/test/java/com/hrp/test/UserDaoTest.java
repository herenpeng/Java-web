package com.hrp.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrp
 * 2020/3/16 8:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * 通过Id查找用户
     */
    @Test
    public void test01(){
        User user = userDao.selectById(1);
        System.out.println(user);
    }

    /**
     * 查找全部用户
     */
    @Test
    public void test02(){
        List<User> list = userDao.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 通过Map集合查找用户
     *      Map集合中key为数据库字段名，value为数据
     */
    @Test
    public void test03(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","zero");
        map.put("name","零");
        List<User> list = userDao.selectByMap(map);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 分页查找用户，current为当前页（索引从1开始），size为当前页大小
     */
    @Test
    public void test04(){
        IPage<User> page = new Page<>(2,3);
        IPage<User> UserPage = userDao.selectPage(page, null);
        for (User user : UserPage.getRecords()) {
            System.out.println(user);
        }
    }

    /**
     * 插入用户信息
     */
    @Test
    public void test05(){
        User user = new User();
        user.setUsername("阿部多瑞");
        user.setPassword("123");
        user.setName("宣墨");
        user.setGender(0);
        user.setBirthday(new Date());
        user.setPhone("154845129875");
        user.setPower(2);
        userDao.insert(user);
    }

}
