package com.example.dtsplatform.mapper;

import com.example.dtsplatform.dto.request.RegisterRequestDto;
import com.example.dtsplatform.dto.response.UserResponseDto;
import com.example.dtsplatform.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract Users toEntity(RegisterRequestDto registerRequestDto);

    public abstract UserResponseDto toDto(Users user);
}
