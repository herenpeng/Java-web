package com.amqp.direct;

import com.amqp.util.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author hrp
 * 2020/3/24 9:47
 */
public class Send {
    //RabbitMQ的交换机名称
    private final static String EXCHANGE_NAME = "amq.direct";

    public static void main(String[] argv) throws Exception {
        //使用工具类，获取RabbitMQ的连接
        Connection connection = ConnectionUtils.getConnection();
        //使用连接创建通道
        Channel channel = connection.createChannel();
        //声明交换机exchange，指定类型为fanout，BuiltinExchangeType是一个枚举类，最后一个参数为指定交换机的持久化属性
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,true);
        //需要发送的消息
        String insert_message = "插入数据";
        //使用通道发送消息到交换机，参数分别为：交换机名称，路由Key，其他属性，消息正文
        channel.basicPublish(EXCHANGE_NAME, "insert", null, insert_message.getBytes());
        //需要发送的消息
        String delete_message = "删除数据";
        //使用通道发送消息到交换机，参数分别为：交换机名称，路由Key，其他属性，消息正文
        channel.basicPublish(EXCHANGE_NAME, "delete", null, delete_message.getBytes());
        //关闭通道
        channel.close();
        //关闭连接
        connection.close();
    }
}
