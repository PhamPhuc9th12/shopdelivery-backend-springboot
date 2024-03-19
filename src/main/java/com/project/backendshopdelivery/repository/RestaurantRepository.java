package com.project.backendshopdelivery.repository;

import com.project.backendshopdelivery.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
