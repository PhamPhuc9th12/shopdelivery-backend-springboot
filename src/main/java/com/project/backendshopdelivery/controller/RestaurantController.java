package com.project.backendshopdelivery.controller;

import com.project.backendshopdelivery.dto.RestaurantRequest;
import com.project.backendshopdelivery.service.FileService;
import com.project.backendshopdelivery.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/upload/res")
@AllArgsConstructor
public class RestaurantController {
    private final FileService fileService;
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtile,
            @RequestParam String description,
            @RequestParam boolean isFreeship,
            @RequestParam String address,
            @RequestParam String openDate)

    {

        return new ResponseEntity<>(restaurantService.insertRestaurant(file,title,subtile,description,isFreeship,
                address,  openDate), HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.*}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        Resource resource = fileService.loadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename =\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
