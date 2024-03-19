package com.project.backendshopdelivery.dto;

import lombok.*;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private Page<FoodResponse> foodResponses;
}
