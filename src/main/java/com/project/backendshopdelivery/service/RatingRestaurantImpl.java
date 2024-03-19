package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.entity.RatingRestaurantEntity;
import com.project.backendshopdelivery.repository.RatingRestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingRestaurantImpl implements RatingRestaurantService{
    private final RatingRestaurantRepository ratingRestaurantRepository;
    @Override
    public double getRating(long restaurantId) {

        List<RatingRestaurantEntity>  ratingRestaurantEntities = ratingRestaurantRepository.findAllByResId(restaurantId);
        if(ratingRestaurantEntities.size() == 0){
            return 0;
        }else{
            long peopleRateNumber = ratingRestaurantEntities.size();
            long totalPoint = 0;
            for(RatingRestaurantEntity restaurantEntity:ratingRestaurantEntities){
                totalPoint += restaurantEntity.getRatePoint();
            }
            double ratingPoint =(double)(totalPoint/peopleRateNumber);
            return ratingPoint;
        }

    }
}
