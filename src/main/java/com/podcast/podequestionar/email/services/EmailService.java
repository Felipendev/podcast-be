package com.podcast.podequestionar.email.services;

import com.podcast.podequestionar.email.enums.StatusEmail;
import com.podcast.podequestionar.email.models.EmailModel;
import com.podcast.podequestionar.email.repositories.EmailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Log4j2
public class EmailService {

    private EmailRepository emailRepository;

    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        log.info("[start] EmailService - sendEmail");
        emailModel.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            EmailModel emailSaved = emailRepository.save(emailModel);
            log.info("[finish] EmailService - sendEmail");
            return emailSaved;
        }
    }
}
