package org.youssef.habit_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.habit_tracker.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username); // Find user by username

    Boolean existsByUsername(String username); // Check if a user with the given username exists
    Boolean existsByEmail(String email);// Check if a user with the given email exists
}