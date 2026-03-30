package com.gayatri.smarttask.backend.exceptionhandling;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message){
        super(message);
    }
}
