package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResetPassword {
    private String email;
    private String password;
    private String confirmPassword;
    
}
