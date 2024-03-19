package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.dto.UserResponse;
import com.project.backendshopdelivery.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public List<UserResponse> getListUsers() {
        return userService.getusers();
    }
}
