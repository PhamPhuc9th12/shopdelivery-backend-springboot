package com.project.backendshopdelivery.repository;

import com.project.backendshopdelivery.entity.FoodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    Page<FoodEntity> getAllByCateId(Long cateId, Pageable pageable);

}
