package com.example.rabbit.fanout;

import com.example.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTestApplication {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void testTopic()  {
            topicSender.sender(new Date());
    }
}
