package com.example.rabbit.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicReceiverA {

    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void receiver(Message message, Channel channel) throws IOException {
        try {
            System.out.println("topic.message接收消息时间："+new String(message.getBody(),"utf-8"));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            System.out.println("消息异常");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,true);
        }
    }
}
