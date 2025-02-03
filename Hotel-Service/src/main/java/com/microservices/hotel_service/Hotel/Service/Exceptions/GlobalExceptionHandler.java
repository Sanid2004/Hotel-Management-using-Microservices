package com.microservices.hotel_service.Hotel.Service.Exceptions;

import com.microservices.hotel_service.Hotel.Service.Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> GlobalException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
