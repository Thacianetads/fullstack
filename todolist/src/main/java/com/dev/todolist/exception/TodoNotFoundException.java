package com.dev.todolist.exception;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(String message){
        super (message);
    }
    
}
