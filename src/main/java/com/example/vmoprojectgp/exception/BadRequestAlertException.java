package com.example.vmoprojectgp.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.List;

@ControllerAdvice
public class BadRequestAlertException extends RuntimeException {
    private List<Errors> errors;

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

    public BadRequestAlertException() {
    }
}

