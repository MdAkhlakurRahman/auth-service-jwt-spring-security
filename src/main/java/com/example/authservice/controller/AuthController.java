package com.example.authservice.controller;

import com.example.authservice.security.JwtUtil;
import com.example.authservice.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          AuthService authService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public String login(@RequestBody AuthRequest req) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.username, req.password
                )
        );

        return jwtUtil.generateToken(req.username);
    }

    @PostMapping("/register")
    public String register() {
        System.out.println("🔥 REGISTER ENDPOINT HIT");

        authService.registerUser(
                "testuser",
                "test@test.com",
                "password"
        );
        return "User created";
    }


}
