package com.project.backendshopdelivery.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(UserExceptionHandle.class)
    public ResponseEntity<ErrorDetail> userExceptionHandle(UserExceptionHandle userExceptionHandle){
        ErrorDetail errorDetail = new ErrorDetail(userExceptionHandle.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.UNAUTHORIZED);
    }
}
