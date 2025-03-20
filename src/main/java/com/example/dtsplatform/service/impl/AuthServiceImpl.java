package com.example.dtsplatform.service.impl;

import com.example.dtsplatform.dto.request.LoginRequestDto;
import com.example.dtsplatform.dto.request.RegisterRequestDto;
import com.example.dtsplatform.dto.response.ExceptionDTO;
import com.example.dtsplatform.dto.response.LoginRes;
import com.example.dtsplatform.dto.response.UserResponseDto;
import com.example.dtsplatform.entity.Users;
import com.example.dtsplatform.enums.Role;
import com.example.dtsplatform.exception.AlreadyExistException;
import com.example.dtsplatform.mapper.UserMapper;
import com.example.dtsplatform.repository.UserRepository;
import com.example.dtsplatform.service.AuthService;
import com.example.dtsplatform.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final JavaMailSender mailSender;
    private final UserRepository usersRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserResponseDto register(RegisterRequestDto registerRequestDto) {
        log.info("Admin register method started");
        if (usersRepository.findByEmail(registerRequestDto.getEmail()).isPresent()) {
            throw new AlreadyExistException("This user already exist");
        }
            registerRequestDto.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
            Users user = userMapper.toEntity(registerRequestDto);
            user.setRole(Role.ADMIN);
            Users savedUser = usersRepository.save(user);
            UserResponseDto userDTO = userMapper.toDto(savedUser);
            log.info("user registered as a admin role, gmail: {}", user.getEmail());
            return userDTO;
        }


    @Override
    public ResponseEntity<?> authenticate(LoginRequestDto request) {
        log.info("authenticate method started by: {}", request.getEmail());
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                            request.getPassword()));
            log.info("authentication details: {}", authentication);
            String email = authentication.getName();
            Users users = new Users(email, "");
            String token = jwtUtil.createToken(users);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            LoginRes loginRes = new LoginRes(email, token);
            log.info("user: {} logged in", users.getEmail());
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(loginRes);

        } catch (BadCredentialsException e) {
            ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "Invalid gmail or password");
            log.error("Error due to {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
        } catch (Exception e) {
            ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            log.error("Error due to {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
        }    }
}
