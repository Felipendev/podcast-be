package com.podcast.podequestionar.email.configs;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class RabbitMQConfig {

//    @Value("${spring.rabbitmq.queue}")
//    private String queue;
//
//    @Bean
//    public Queue queue() {
//        log.info("[start] RabbitMQConfig - queue");
//        Queue queue = new Queue(this.queue, true);
//        log.info("[finish] RabbitMQConfig - queue");
//        return queue;
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter messageConverter() {
//        log.info("[start] RabbitMQConfig - MessageConverter");
//        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
//        log.info("[finish] RabbitMQConfig - MessageConverter");
//        return messageConverter;
//    }
}
