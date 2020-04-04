package com.hrp.test;

import com.hrp.service.SpikeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hrp
 * 2020/3/18 23:01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpikeTest {

    @Autowired
    private SpikeService spikeService;

    /**
     * 执行商品秒杀前，将商品存入数据库中，已存入5件商品
     */
    @Before
    public void addStock() {
        spikeService.addStock(5);
    }

    /**
     * 商品秒杀测试，使用两个线程一起秒杀
     */
    @Test
    public void spike() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Object obj = new Object();
        es.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "正在秒杀");
            while (true) {
                String commodity = spikeService.spike();
                if (commodity != null) {
                    System.out.println(Thread.currentThread().getName() + "抢到了商品" + commodity);
                } else {
                    System.out.println("商品被抢完了");
                    break;
                }
            }
        });
        es.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "正在秒杀");
            while (true) {
                String commodity = spikeService.spike();
                if (commodity != null) {
                    System.out.println(Thread.currentThread().getName() + "抢到了商品" + commodity);
                } else {
                    System.out.println("商品被抢完了");
                    break;
                }
            }
        });
    }

    /**
     * 单线程环境秒杀
     */
    @Test
    public void del() {
        while (true) {
            String commodity = spikeService.spike();
            if (commodity != null) {
                System.out.println(Thread.currentThread().getName() + "抢到了商品" + commodity);
            } else {
                System.out.println("商品被抢完了");
                break;
            }
        }
    }
}
