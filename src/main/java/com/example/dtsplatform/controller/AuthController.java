package com.example.dtsplatform.controller;

import com.example.dtsplatform.dto.request.LoginRequestDto;
import com.example.dtsplatform.dto.request.RegisterRequestDto;
import com.example.dtsplatform.dto.response.UserResponseDto;
import com.example.dtsplatform.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid RegisterRequestDto customerRegisterDTO) {
        return authService.register(customerRegisterDTO);
    }

    @ResponseBody
    @PostMapping("/log-in")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDto loginReq) {
        return authService.authenticate(loginReq);
    }
}
