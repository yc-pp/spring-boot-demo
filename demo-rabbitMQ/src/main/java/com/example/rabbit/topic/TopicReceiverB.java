package com.example.rabbit.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicReceiverB {

    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
    public void receiver(Message message, Channel channel) throws IOException {
        try {
            System.out.println("topic.messages接收消息时间："+new String(message.getBody(),"utf-8"));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }
    }
}
