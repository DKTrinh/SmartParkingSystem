package com.smartparking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartparking.dto.LoginRequest;
import com.smartparking.dto.LoginResponse;
import com.smartparking.entity.User;
import com.smartparking.service.AuthService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = authService.login(
                request.getUsername(),
                request.getPassword());

        if (user != null) {
            return ResponseEntity.ok(
                    new LoginResponse(
                            "fake-token",
                            user.getId(),
                            user.getName(),
                            user.getRole().name()
                    )
            );
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid credentials");
    }
}