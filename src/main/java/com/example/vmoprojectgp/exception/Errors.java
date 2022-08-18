package com.example.vmoprojectgp.exception;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errors {
    private String errorCode;
    private String errorDetail;

    public Errors() {
    }

    public Errors(String errorCode, String errorDetail) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
