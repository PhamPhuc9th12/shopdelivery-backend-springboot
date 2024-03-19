package com.project.backendshopdelivery.repository;

import com.project.backendshopdelivery.entity.RatingRestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRestaurantRepository extends JpaRepository<RatingRestaurantEntity, Long> {
    List<RatingRestaurantEntity> findAllByResId(Long restaurantId);
}
