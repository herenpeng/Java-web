package com.hrp.test;

import com.hrp.service.SortService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author hrp
 * 2020/3/19 17:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SortTest {

    @Autowired
    private SortService sortService;

    private final static String[] NAME = {"张三","李四","王五","赵六","田七","孙八"};

    @Before
    public void onClick(){
        for (int i = 0; i < 1000; i++) {
            String name = NAME[new Random().nextInt(6)];
            sortService.onClick(name,-1.0);
        }
    }

    @Test
    public void test(){
        Set<String> set = sortService.getSort();
        int i = 1;
        for (String str : set) {
            Double score = sortService.getScore(str);
            System.out.println("第"+i+"名为："+str+"排名分数为："+score);
            i++;
        }

    }
}
