package com.hrp.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 日志测试
 * @author: 何任鹏
 * @create: 2020/8/22 7:59
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoggerTest {

    @Test
    public void test01 () {
        log.info("记录日志信息");
    }



}
