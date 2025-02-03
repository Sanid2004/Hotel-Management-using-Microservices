package com.microservices.hotel_service.Hotel.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s){
        super(s);
    }

    public ResourceNotFoundException(){
        super(" The given resource not found on server!! ");
    }
}
