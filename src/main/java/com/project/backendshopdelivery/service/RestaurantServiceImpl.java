package com.project.backendshopdelivery.service;

import com.project.backendshopdelivery.dto.RestaurantRequest;
import com.project.backendshopdelivery.mapper.RestaurantMapper;
import com.project.backendshopdelivery.model.RestaurantEntity;
import com.project.backendshopdelivery.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final FileService fileService;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtile, String description, boolean isFreeship,
                                    String address, String openDate) {
     try{
         if (fileService.saveFile(file)) {
             RestaurantEntity restaurantEntity = new RestaurantEntity();
             restaurantEntity.setTitle(title);
             restaurantEntity.setSubtitle(subtile);
             restaurantEntity.setDescription(description);
             restaurantEntity.setFreeship(isFreeship);
             restaurantEntity.setAddress(address);
             restaurantEntity.setImage(file.getOriginalFilename());
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

             Date opendate = simpleDateFormat.parse(openDate);

             restaurantEntity.setOpenDate(opendate);

             restaurantRepository.save(restaurantEntity);
             return true;
         }
     }catch(Exception e){
         System.out.println("errroooo");
     }
        return false;
    }
}
