package com.example.dtsplatform.dto.request;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
