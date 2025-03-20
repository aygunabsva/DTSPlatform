package com.example.dtsplatform.dto.response;

import com.example.dtsplatform.enums.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
