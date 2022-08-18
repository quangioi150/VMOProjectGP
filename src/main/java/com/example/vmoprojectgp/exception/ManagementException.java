package com.example.vmoprojectgp.exception;

import java.util.List;

public class ManagementException extends RuntimeException {
    private List<Errors> errors;
    private String message;
    public ManagementException(String message) {
        super(message);
    }
    public ManagementException(List<Errors> errors, String message) {
        this.errors = errors;
        this.message = message;
    }
    public List<Errors> getErrors() {
        return errors;
    }
    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

