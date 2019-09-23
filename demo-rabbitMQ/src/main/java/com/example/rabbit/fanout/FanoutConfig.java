package com.example.rabbit.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    /**
     * 创建队列fanout.A
     * @return
     */
    @Bean
    public Queue queueFanoutA(){
        return new Queue("fanout.A");
    }

    /**
     * 创建队列fanout.B
     * @return
     */
    @Bean
    public Queue queueFanoutB(){
        return new Queue("fanout.B");
    }

    /**
     * 创建队列fanout.C
     * @return
     */
    @Bean
    public Queue queueFanoutC(){
        return new Queue("fanout.C");
    }

    /**
     * 创建Fanout类型交换机fanoutExchange
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定队列fanout.A到交换机上
     * @param queueFanoutA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeFanoutA(Queue queueFanoutA,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueFanoutA).to(fanoutExchange);
    }

    /**
     * 绑定队列fanout.B到交换机上
     * @param queueFanoutB
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeFanoutB(Queue queueFanoutB,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueFanoutB).to(fanoutExchange);
    }

    /**
     * 绑定队列fanout.C到交换机上
     * @param queueFanoutC
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeFanoutC(Queue queueFanoutC,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueFanoutC).to(fanoutExchange);
    }

}
