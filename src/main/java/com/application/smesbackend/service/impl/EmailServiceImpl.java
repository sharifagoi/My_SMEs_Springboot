package com.application.smesbackend.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

import com.application.smesbackend.exception.EmailSendingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.application.smesbackend.dto.EmailRequestDTO;
import com.application.smesbackend.service.EmailService;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;


    @Override
    public void sendEmail(EmailRequestDTO emailRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            if (emailRequest.getCc() != null && !emailRequest.getCc().isEmpty()) {
                helper.setCc(emailRequest.getCc().toArray(new String[0]));
            }
            if (emailRequest.getBcc() != null && !emailRequest.getBcc().isEmpty()) {
                helper.setBcc(emailRequest.getBcc().toArray(new String[0]));
            }
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailSendingException("Failed to send email", e);
        }
    }
}