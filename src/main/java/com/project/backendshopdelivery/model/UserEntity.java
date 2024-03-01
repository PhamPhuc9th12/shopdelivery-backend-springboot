package com.project.backendshopdelivery.model;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_users")
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private Long roleId;
    private LocalDateTime createdDate;
}
