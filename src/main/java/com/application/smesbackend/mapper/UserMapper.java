package com.application.smesbackend.mapper;

import com.application.smesbackend.dto.UserDto;
import com.application.smesbackend.entity.Role;
import com.application.smesbackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword()); // Do not encode the password here
        user.setRole(Role.valueOf(userDto.getRole()));
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(null); // Hide password
        userDto.setRole(user.getRole().name());
        return userDto;
    }
}