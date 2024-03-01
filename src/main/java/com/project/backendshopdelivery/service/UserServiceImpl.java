package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.model.UserEntity;
import com.project.backendshopdelivery.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public void signup(SignupRequest signupRequest) {
        signupRequest.setPassword(BCrypt.hashpw(signupRequest.getPassword(), BCrypt.gensalt()));
        UserEntity userEntity = UserEntity.builder()
                .userName(signupRequest.getUserName())
                .password(signupRequest.getPassword())
                .fullName(signupRequest.getFullName())
                .roleId(null)
                .createdDate(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return null;
    }
}
