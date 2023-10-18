package com.example.postgres.ExeceptionHandling;

public class EmployeeIdExistsException extends RuntimeException {
    public EmployeeIdExistsException(String message) {
        super(message);
    }
}