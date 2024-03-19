package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.CategoryResponse;
import com.project.backendshopdelivery.entity.CategoryEntity;
import com.project.backendshopdelivery.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final FoodService foodService;
    @Override
    public Page<CategoryResponse> getCategoryAndMenu(Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable);
        Pageable pageableFood = PageRequest.of(0,3);
        Page<CategoryResponse> categoryResponses = categoryEntities
                .map(
                        categoryEntity -> {
                            CategoryResponse categoryResponse = CategoryResponse.builder()
                                    .id(categoryEntity.getId())
                                    .name(categoryEntity.getNameCate())
                                    .foodResponses(foodService.getAllFood(categoryEntity.getId(),pageableFood))
                                    .build();
                            return categoryResponse;
                        }

                );
        return categoryResponses;
    }
}
