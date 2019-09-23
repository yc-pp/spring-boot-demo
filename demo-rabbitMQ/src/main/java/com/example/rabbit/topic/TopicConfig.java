package com.example.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicConfig {
    /**
     * 创建队列topic.message
     * @return
     */
    @Bean
    public Queue queueTopicA(){
        return new Queue("topic.message");
    }

    /**
     * 创建队列topic.messages
     * @return
     */
    @Bean
    public Queue queueTopicB(){
        return new Queue("topic.messages");
    }

    /**
     * 创建topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定topic.message队列到交换机上
     * @param queueTopicA
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicA(Queue queueTopicA,TopicExchange topicExchange){
        return BindingBuilder.bind(queueTopicA).to(topicExchange).with("topic.message");
    }

    /**
     * 绑定topic.#队列到交换机上
     * #代表零个或多个单词
     * @param queueTopicB
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicB(Queue queueTopicB,TopicExchange topicExchange){
        return BindingBuilder.bind(queueTopicB).to(topicExchange).with("topic.#");
    }
}
