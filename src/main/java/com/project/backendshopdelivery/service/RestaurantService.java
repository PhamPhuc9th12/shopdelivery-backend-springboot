package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.RestaurantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantService {
    boolean insertRestaurant(MultipartFile file, String title, String subtile, String description,boolean isFreeship,
                             String address, String openDate);
    Page<RestaurantResponse> getAllRestaurant(Pageable pageable);
}
