package com.hrp.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.domain.Category;
import com.hrp.domain.User;
import com.hrp.mapper.CategoryMapper;
import com.hrp.service.UserService;
import com.hrp.util.UploadUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hrp
 * 2020/2/21 11:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test1(){
        String s = UploadUtils.generateFileName("123.jpg");
        System.out.println(s);
    }

    @Test
    public void categoryTest() throws Exception {
        IPage<Category> page = new Page<>(2,3);
        List<Category> list = categoryMapper.findByPage(page);
        for (Category category : list) {
            System.out.println(category);
        }
    }


}
