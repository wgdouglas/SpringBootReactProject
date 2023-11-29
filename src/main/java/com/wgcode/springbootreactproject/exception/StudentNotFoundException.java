package com.wgcode.springbootreactproject.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String studentNotFoundInDatabaseMessage) {
        super(studentNotFoundInDatabaseMessage);
    }
}
