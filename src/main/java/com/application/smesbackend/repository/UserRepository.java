package com.application.smesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.smesbackend.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by email (optional, for login functionality, etc.)
    Optional<User> findByEmail(String email);
}

