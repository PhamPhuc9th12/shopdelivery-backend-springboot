package com.project.backendshopdelivery.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodResponse {
    private Long id;
    private String title;
    private String image;
    private String timeShip;
    private Long price;
    private boolean isFreeship;
    private Long cateId;
}
