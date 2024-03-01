package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public void getUser(@RequestBody SignupRequest signupRequest){
        userService.signup(signupRequest);
    }
}
