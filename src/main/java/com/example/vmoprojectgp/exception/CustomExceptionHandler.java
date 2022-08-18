package com.example.vmoprojectgp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler( value = {BadRequestAlertException.class} )
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ErrorResponse handerBadRequestException(BadRequestAlertException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getErrors());
    }

    @ExceptionHandler( value = {MethodArgumentNotValidException.class} )
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ErrorResponse handlerNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        List<Errors> errorsList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((err) -> {
            Errors errors = new Errors();
            errors.setErrorCode(err.getCode());
            errors.setErrorDetail(err.getDefaultMessage());
            errorsList.add(errors);
        });
        errorResponse.setErrorsList(errorsList);
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorsList);
    }

    @ExceptionHandler( value = {ManagementException.class} )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public ErrorResponse handlerManagementException(ManagementException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getErrors());
    }
}
