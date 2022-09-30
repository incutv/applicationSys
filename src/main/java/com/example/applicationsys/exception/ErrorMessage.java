package com.example.applicationsys.exception;

public enum ErrorMessage {

    INVALID_TIME_FORMAT("1","파라미터가 날짜포맷이 맞지 않습니다.");

    private String errorCode;
    private String errorMessage;

    ErrorMessage(String errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
