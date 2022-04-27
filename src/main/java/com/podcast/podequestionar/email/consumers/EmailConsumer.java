package com.podcast.podequestionar.email.consumers;

import com.podcast.podequestionar.email.dtos.EmailDto;
import com.podcast.podequestionar.email.models.EmailModel;
import com.podcast.podequestionar.email.services.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class EmailConsumer {

    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        log.info("[start] EmailConsumer - listen");
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
        log.info("[finish] EmailConsumer - listen");

    }
}
