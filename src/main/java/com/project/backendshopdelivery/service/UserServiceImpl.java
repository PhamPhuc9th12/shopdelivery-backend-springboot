package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.LoginRequest;
import com.project.backendshopdelivery.dto.SignupRequest;
import com.project.backendshopdelivery.dto.UserResponse;
import com.project.backendshopdelivery.mapper.UserMapper;
import com.project.backendshopdelivery.model.UserEntity;
import com.project.backendshopdelivery.repository.UserRepository;
import com.project.backendshopdelivery.token.TokenHelper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{



    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void signup(SignupRequest signupRequest) {
        signupRequest.setPassword(BCrypt.hashpw(signupRequest.getPassword(), BCrypt.gensalt()));
        UserEntity userEntity = userMapper.getUserFromInput(signupRequest);
        userRepository.save(userEntity);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.getByUserName(loginRequest.getUserName());
        if(Objects.isNull(userEntity)) throw new RuntimeException("Null Object");
        String hashedPassword = userEntity.getPassword();
        if(BCrypt.checkpw(loginRequest.getPassword(),hashedPassword)){
            return TokenHelper.generateToken(userEntity);
        }
        throw new RuntimeException("can't login");
    }

    @Override
    public List<UserResponse> getusers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for(UserEntity userEntity: userEntities){
            userResponses.add(UserResponse.builder()
                    .id(userEntity.getId())
                    .userName(userEntity.getUserName())
                    .fullName(userEntity.getFullName())
                    .build()
            );
        }
        return userResponses;
    }


}
