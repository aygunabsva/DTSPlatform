package com.example.dtsplatform.service;

import com.example.dtsplatform.dto.request.LoginRequestDto;
import com.example.dtsplatform.dto.request.RegisterRequestDto;
import com.example.dtsplatform.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    UserResponseDto register(RegisterRequestDto registerRequestDto);

    ResponseEntity<?> authenticate(LoginRequestDto request);
}
