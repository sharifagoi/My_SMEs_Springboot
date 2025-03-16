package com.application.smesbackend.service.impl;

import com.application.smesbackend.dto.PasswordDto;
import com.application.smesbackend.dto.UserDto;
import com.application.smesbackend.entity.User;
import com.application.smesbackend.mapper.UserMapper;
import com.application.smesbackend.repository.UserRepository;
import com.application.smesbackend.service.UserService;

import lombok.AllArgsConstructor;

import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String USER_NOT_FOUND_MESSAGE = "User not found";

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user.setPassword(encoder.encode(user.getPassword())); // Encode the password here
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException(USER_NOT_FOUND_MESSAGE);
        }
        return UserMapper.toDto(user.get());
    }

    @Override
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND_MESSAGE));

        logger.info("Logging in user with email: {}", email);
        logger.info("Provided password: {}", password);
        logger.info("Stored encoded password: {}", user.getPassword());

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return UserMapper.toDto(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException(USER_NOT_FOUND_MESSAGE);
        }
        userRepository.delete(user.get());
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException(USER_NOT_FOUND_MESSAGE);
        }
        return UserMapper.toDto(user.get());
    }

    @Override
    public boolean updateUserPassword(PasswordDto passwordDto) {
        User user = userRepository.findByEmail(passwordDto.getEmail())
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND_MESSAGE));
        user.setPassword(encoder.encode(passwordDto.getPassword()));
        userRepository.save(user);
        return true;
    }
}