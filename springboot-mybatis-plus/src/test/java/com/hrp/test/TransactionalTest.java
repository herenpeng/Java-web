package com.hrp.test;

import com.hrp.domain.Category;
import com.hrp.domain.User;
import com.hrp.service.CategoryService;
import com.hrp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hrp
 * 2020/3/21 13:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionalTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;


    @Test
    public void test() throws Exception {
        User user = new User();
        user.setUsername("小山");
        user.setPassword("123");
        user.setName("珊珊");
        userService.insert(user);

        Category category = new Category();
        category.setName("家具");
        category.setParent(0);
        categoryService.addCategory(category);
    }
}
