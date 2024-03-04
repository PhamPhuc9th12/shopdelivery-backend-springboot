package com.project.backendshopdelivery.mapper;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity getUserFromInput(SignupRequest signupRequest);
    UserEntity getUserFromInput(LoginRequest loginRequest);
}
