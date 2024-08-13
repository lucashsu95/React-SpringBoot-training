package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class AccessTokenValidator {

    private final UserRepository userRepository;

    public AccessTokenValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> validate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || header.isEmpty()) {
            return ApiResponse.INVALID_ACCESS_TOKEN();
        }

        String[] parts = header.split(" ");
        if (parts.length == 2 && "Bearer".equals(parts[0])) {
            String token = parts[1];
            Optional<User> userOptional = userRepository.findByAccessToken(token);
            if (userOptional.isPresent()) {
                return null; // Token valid
            }
        }

        return ApiResponse.INVALID_ACCESS_TOKEN();
    }
}