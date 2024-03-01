package com.project.backendshopdelivery.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String userName;
    private String password;
    private String fullName;
    private Long roleId;
    private LocalDateTime createdDate;
}
