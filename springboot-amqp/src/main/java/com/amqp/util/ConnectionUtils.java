package com.amqp.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * @author hrp
 * 2020/3/22 17:22
 */
public class ConnectionUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置连接IP地址
        factory.setHost("192.168.177.128");
        //设置连接端口号
        factory.setPort(5672);
        //设置RabbitMQ连接的虚拟主机
        factory.setVirtualHost("/mymq");
        //设置RabbitMQ的用户名
        factory.setUsername("admin");
        //设置RabbitMQ的密码
        factory.setPassword("admin");
        //使用连接工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
