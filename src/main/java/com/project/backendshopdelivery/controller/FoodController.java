package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.FoodResponse;
import com.project.backendshopdelivery.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/food")
public class FoodController {
    private final FoodService foodService;

    @Operation(summary = "create food for menu")
    @PostMapping
    public boolean createFood(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String timeShip,
            @RequestParam Long price,
            @RequestParam Boolean isFreeship,
            @RequestParam Long cateId
    ) {
        return foodService.insertFood(file, title, isFreeship, price, cateId, timeShip);
    }

    @Operation(summary = "get menu in category")
    @GetMapping("/menu")
    public Page<FoodResponse> getFoodFromCategory(@RequestParam Long cateId, @ParameterObject Pageable pageable) {
        return foodService.getAllFood(cateId, pageable);
    }

}
