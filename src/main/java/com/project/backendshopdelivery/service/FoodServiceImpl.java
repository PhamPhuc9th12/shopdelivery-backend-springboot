package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.FoodResponse;
import com.project.backendshopdelivery.entity.FoodEntity;
import com.project.backendshopdelivery.entity.RestaurantEntity;
import com.project.backendshopdelivery.mapper.FoodMapper;
import com.project.backendshopdelivery.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;
    private final FileService fileService;
    private final FoodMapper foodMapper;
    @Override
    public boolean insertFood(MultipartFile file, String title, boolean isFreeship, Long price, Long cateId, String timeShip) {
        try {
            if (fileService.saveFile(file)) {
                FoodEntity foodEntity = new FoodEntity();
                foodEntity.setTitle(title);
                foodEntity.setFreeship(isFreeship);
                foodEntity.setPrice(price);
                foodEntity.setCateId(cateId);
                foodEntity.setImage(file.getOriginalFilename());
                foodEntity.setTimeShip(timeShip);
                foodRepository.save(foodEntity);
                return true;
            }
        } catch (Exception e) {
            System.out.println("errroooo");
        }
        return false;
    }

    @Override
    public Page<FoodResponse> getAllFood(Long cateId,Pageable pageable) {
        Page<FoodResponse> foodResponses = foodRepository.getAllByCateId(cateId,pageable)
                .map(foodMapper::getOutputFrom);
        return foodResponses;
    }
}
