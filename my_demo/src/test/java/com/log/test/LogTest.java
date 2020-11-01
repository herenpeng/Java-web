package com.log.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;


/**
 * @description: 日志功能测试
 * @author: 何任鹏
 * @create: 2020/8/18 23:09
 */
@Slf4j
public class LogTest {
    /**
     * 使用LoggerFactory创建一个Logger对象
     */
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void logTest01() {
//        logger.info("记录信息日志");
//        logger.warn("记录警告日志");
//        logger.error("记录错误日志");
        log.info("记录信息日志");
        log.warn("记录警告日志");
        log.error("记录错误日志");
    }

    @Test
    public void logTest02() {
        log.info("记录信息日志: {}", "内容");
        log.warn("记录警告日志");
        log.error("记录错误日志");
    }


    public final static String FILE_PATH = "F:\\Maven\\repository";
    public final static String suffix = ".lastUpdated";
    //    public final static String suffix = "_remote.repositories";
    //    public final static String suffix = "${";
    public static int count = 0;

    @Test
    public void delMavenError() {
        deleteErrorFile(new File(FILE_PATH));
        System.out.println("一共在Maven仓库中删除了" + count + "个错误文件");
    }

    public static void deleteErrorFile(File file) {
        if (file.isDirectory()) {
            for (String childrenFile : file.list()) {
                deleteErrorFile(new File(file, childrenFile));
            }
        } else {
            if (file.getName().endsWith(suffix)) {
                System.out.println(file.getAbsolutePath());
                file.delete();
                count++;
            }
        }
    }

}
