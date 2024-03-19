package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.CategoryResponse;
import com.project.backendshopdelivery.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Operation(summary = "get list category and menu")
    @GetMapping("/category")
    public Page<CategoryResponse> getAllCategoryAndMenu(@ParameterObject Pageable pageable){
        return categoryService.getCategoryAndMenu(pageable);
    }

}
