package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;

public interface UserService {
    void signup (SignupRequest signupRequest);
    String login (LoginRequest loginRequest);
}
