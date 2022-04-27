package com.podcast.podequestionar.email.controllers;

import com.podcast.podequestionar.email.dtos.EmailDto;
import com.podcast.podequestionar.email.models.EmailModel;
import com.podcast.podequestionar.email.services.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Log4j2
public class EmailController {

    private EmailService emailService;

    @CrossOrigin
    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        log.info("[start] EmailController - sendingEmail");
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        log.info("[finish] EmailController - sendingEmail");
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
