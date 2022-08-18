package com.example.vmoprojectgp.exception;
import org.springframework.http.HttpStatus;
import java.util.List;

public class ErrorResponse {
    private HttpStatus status;
    List<Errors> errorsList;

    public ErrorResponse(HttpStatus status, List<Errors> errorsList) {
        this.status = status;
        this.errorsList = errorsList;
    }

    public ErrorResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<Errors> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<Errors> errorsList) {
        this.errorsList = errorsList;
    }
}
