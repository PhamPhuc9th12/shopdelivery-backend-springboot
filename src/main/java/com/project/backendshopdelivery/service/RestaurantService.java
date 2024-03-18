package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.RestaurantRequest;
import com.project.backendshopdelivery.model.RestaurantEntity;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantService {
    boolean insertRestaurant(MultipartFile file, String title, String subtile, String description,boolean isFreeship,
                             String address, String openDate);
}
