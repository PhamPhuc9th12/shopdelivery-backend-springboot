package com.project.backendshopdelivery.mapper;

import com.project.backendshopdelivery.dto.FoodResponse;
import com.project.backendshopdelivery.entity.FoodEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FoodMapper {
    FoodResponse getOutputFrom(FoodEntity foodEntity);
}
