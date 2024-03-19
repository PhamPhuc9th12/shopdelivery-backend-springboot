package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponse> getCategoryAndMenu(Pageable pageable);
}
