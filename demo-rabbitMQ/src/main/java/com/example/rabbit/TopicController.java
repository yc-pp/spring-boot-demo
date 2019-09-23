package com.example.rabbit;

import com.example.rabbit.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TopicController {
    @Autowired
    private TopicSender topicSender;
    @RequestMapping("/demo")
    public String index(){
        topicSender.sender(new Date());
        return "Yes";
    }
}
