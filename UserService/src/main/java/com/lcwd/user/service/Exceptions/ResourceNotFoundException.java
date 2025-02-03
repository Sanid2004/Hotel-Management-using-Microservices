package com.lcwd.user.service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Not found on server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
