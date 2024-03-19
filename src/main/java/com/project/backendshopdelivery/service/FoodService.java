package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.FoodResponse;
import com.project.backendshopdelivery.dto.RestaurantResponse;
import com.project.backendshopdelivery.entity.FoodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {
    boolean insertFood(MultipartFile file, String title,  boolean isFreeship,
                            Long price, Long cateId, String timeShip);
    Page<FoodResponse> getAllFood(Long cateId, Pageable pageable);
}
