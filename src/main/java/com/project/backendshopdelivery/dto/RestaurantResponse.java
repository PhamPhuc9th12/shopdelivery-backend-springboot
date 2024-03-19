package com.project.backendshopdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantResponse {

    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private boolean isFreeship;
    private String address;
    private LocalDateTime openDate;
    private String image;
    private double ratingPoint;
}
