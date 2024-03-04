package com.project.backendshopdelivery.exceptionhandle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserExceptionHandle extends RuntimeException{
    private String message;
}
