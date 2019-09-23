package com.example.rabbit.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class TopicSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String context = sdf.format(date);
        System.out.println("发送消息时间："+context);

        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("发送消息id："+correlationData.getId());
        rabbitTemplate.convertAndSend("topicExchange","topic.message",context,correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回复消息id："+correlationData.getId());
        if(b){
            System.out.println("消息发送成功");
        }else {
            System.out.println("消息发送失败"+s);
        }
    }

    @Override
    public void returnedMessage(Message message, int errCode, String errMsg, String exchange, String routingKey) {
        System.out.println("message：" + message);
        System.out.println("errCode：" + errCode);
        System.out.println("errMsg：" + errMsg);
        System.out.println("exchange：" + exchange);
        System.out.println("routingKey：" + routingKey);
    }
}
