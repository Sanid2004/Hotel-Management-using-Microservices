package com.microservices.hotel_service.Hotel.Service.Payloads;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
