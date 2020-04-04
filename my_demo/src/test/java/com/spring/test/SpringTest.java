package com.spring.test;

import com.spring.web.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrp
 * 2020/3/31 18:33
 */
public class SpringTest {


    @Test
    public void test01(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) app.getBean("userController");
        userController.say();
    }

}
