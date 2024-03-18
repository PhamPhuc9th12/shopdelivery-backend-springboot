package com.project.backendshopdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantRequest {
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private boolean isFreeship;
    private String address;
    private LocalDateTime openDate;
}
