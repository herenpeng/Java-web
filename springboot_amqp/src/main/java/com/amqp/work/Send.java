package com.amqp.work;

import com.amqp.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hrp
 * 2020/3/22 17:29
 */
public class Send {
    //RabbitMQ的队列名称
    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //使用工具类，获取RabbitMQ的连接
        Connection connection = ConnectionUtils.getConnection();
        //使用连接创建通道
        Channel channel = connection.createChannel();
        //使用通道声明一个队列，参数分别为：队列名称，是否持久化，是否为排他队列，是否自动删除，其他属性
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //循环发送50条消息到消息队列中
        for(int i = 0; i < 50; i++){
            //需要发送的消息
            String message = "Hello World!" + i;
            //使用通道发送消息，参数分别为：交换机名称，路由Key，其他属性，消息正文
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        }
        //关闭通道
        channel.close();
        //关闭连接
        connection.close();
    }
}
