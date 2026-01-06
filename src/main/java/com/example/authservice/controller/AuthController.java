package com.example.authservice.controller;

import com.example.authservice.security.JwtUtil;
import com.example.authservice.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          AuthService authService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest req) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.username,
                        req.password
                )
        );

        return jwtUtil.generateToken(req.username);
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        authService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

        return "User registered successfully";
    }
}
