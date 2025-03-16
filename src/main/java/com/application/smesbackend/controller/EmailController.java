package com.application.smesbackend.controller;

import com.application.smesbackend.dto.EmailRequestDTO;
import com.application.smesbackend.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequestDTO emailRequest) {
        emailService.sendEmail(emailRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}