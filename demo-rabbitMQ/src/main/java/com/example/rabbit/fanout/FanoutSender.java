package com.example.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String context = sdf.format(date);
        System.out.println("发送消息时间：" + context);
        amqpTemplate.convertAndSend("fanoutExchange","",context);
    }
}
