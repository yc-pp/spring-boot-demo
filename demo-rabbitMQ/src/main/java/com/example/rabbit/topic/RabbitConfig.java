/*
package com.example.rabbit.topic;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class RabbitConfig {

    @Value("spring.rabbitmq.host")
    private String host;

    @Value("spring.rabbitmq.port")
    private String port;

    @Value("spring.rabbitmq.username")
    private String username;

    @Value("spring.rabbitmq.password")
    private String password;

    @Value("spring.rabbit.publisher-confirms")
    private boolean pubConf;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(host+":"+port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setPublisherConfirms(pubConf);
        return cachingConnectionFactory;
    }
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }
}
*/
