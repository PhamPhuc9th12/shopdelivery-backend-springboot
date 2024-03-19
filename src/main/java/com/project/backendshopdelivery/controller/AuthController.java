package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("api/v1/auth")
@RestController
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest signupRequest) {
        userService.signup(signupRequest);
    }

    @Operation(summary = "Login and receive Token")
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
