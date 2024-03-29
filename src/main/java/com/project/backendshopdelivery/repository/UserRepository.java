package com.project.backendshopdelivery.repository;

import com.project.backendshopdelivery.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity getByUserName(String userName);

}
