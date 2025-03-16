package com.application.smesbackend.service;

import com.application.smesbackend.dto.EmailRequestDTO;

public interface EmailService {
    void sendEmail(EmailRequestDTO emailRequest);
} 