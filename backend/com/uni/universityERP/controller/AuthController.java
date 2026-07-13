package com.uni.universityERP.controller;

import com.uni.universityERP.dto.LoginRequest;
import com.uni.universityERP.dto.LoginResponse;
import com.uni.universityERP.service.AuthService;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")   // Allow requests from anywhere (for development)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody(required = false) LoginRequest request, HttpSession session) {
        if (request == null
                || request.getUsername() == null
                || request.getUsername().trim().isEmpty()
                || request.getPassword() == null
                || request.getPassword().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(LoginResponse.failure("Username and password are required."));
        }

        String username = request.getUsername().trim();
        if (!authService.credentialsMatch(username, request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(LoginResponse.failure("Invalid username or password."));
        }

        session.setAttribute(AuthService.SESSION_AUTHENTICATED, Boolean.TRUE);
        session.setAttribute(AuthService.SESSION_USERNAME, username);

        return ResponseEntity.ok(LoginResponse.success(username));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Boolean>> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of("success", true));
    }
}
