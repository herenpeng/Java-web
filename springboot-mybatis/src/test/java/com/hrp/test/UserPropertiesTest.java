package com.hrp.test;

import com.hrp.properties.Userproperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author hrp
 * 2020/3/22 8:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserPropertiesTest {

    @Autowired
    private Userproperties userproperties;

    @Test
    public void test(){
        System.out.println("用户的姓名是："+userproperties.getName());
        System.out.println("用户的年龄是："+userproperties.getAge());
        System.out.println("用户的爱好是：");
        for (String hobby : userproperties.getHobby()) {
            System.out.println(hobby);
        }
        for (Map.Entry<String, String> entry : userproperties.getFamily().entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
