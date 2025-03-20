package com.example.dtsplatform.configuration;

import com.example.dtsplatform.entity.Users;
import com.example.dtsplatform.enums.Role;
import com.example.dtsplatform.exception.NotFoundException;
import com.example.dtsplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Configuration
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("user not found"));
        Role role = user.getRole();
        List<String> roles = List.of(role.name());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(String.valueOf(roles))
                .build();
    }
}
