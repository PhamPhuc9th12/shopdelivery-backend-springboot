package com.project.backendshopdelivery.mapper;

import com.project.backendshopdelivery.dto.RestaurantRequest;
import com.project.backendshopdelivery.dto.RestaurantResponse;
import com.project.backendshopdelivery.entity.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper {
    public RestaurantEntity getEntityFromInput(RestaurantRequest restaurantRequest);
    public RestaurantResponse getOutputFromEntity(RestaurantEntity restaurantEntity);
}
