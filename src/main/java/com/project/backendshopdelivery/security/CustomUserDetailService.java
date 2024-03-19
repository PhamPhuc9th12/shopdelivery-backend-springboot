package com.project.backendshopdelivery.security;

import com.project.backendshopdelivery.common.Common;
import com.project.backendshopdelivery.entity.UserEntity;
import com.project.backendshopdelivery.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getByUserName(username);
        if(userEntity == null){
            throw new RuntimeException(Common.FAILED_ACTION);
        }

        return new User(username,userEntity.getPassword(), new ArrayList<>());
    }
}
