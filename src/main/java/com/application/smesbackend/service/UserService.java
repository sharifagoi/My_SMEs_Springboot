package com.application.smesbackend.service;

import com.application.smesbackend.dto.PasswordDto;
import com.application.smesbackend.dto.UserDto;
import com.application.smesbackend.entity.User;

import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByEmail(String email);
    UserDto login(String email, String password);

    Optional<User> findByEmail(String email);

    UserDto updateUser(UserDto userDto);

    void deleteUser(String email);

    UserDto getUserById(Long id);

    boolean updateUserPassword(PasswordDto passwordDto);
}