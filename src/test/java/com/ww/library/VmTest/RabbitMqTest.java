package com.ww.library.VmTest;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitMqTest {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "129.204.139.72";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

    @Test
    public  void Producer() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "Hello World !";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        //关闭资源
        channel.close();
        connection.close();

    }

    @Test
    public void Consumer() throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS, PORT)
        };

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //这里的连接方式与生产者的 demo 略有不同,注意辨别区别
        Connection connection = factory.newConnection(addresses); //创建连接
        final Channel channel = connection.createChannel(); //创建信道
        channel.basicQos(64); //设置客户端最多接收未被 ack 的消息的个数
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                System.out.println("recv message : " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
