package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.dto.UserResponse;

import java.util.List;

public interface UserService {
    void signup (SignupRequest signupRequest);
    String login (LoginRequest loginRequest);
    List<UserResponse> getusers();
}
