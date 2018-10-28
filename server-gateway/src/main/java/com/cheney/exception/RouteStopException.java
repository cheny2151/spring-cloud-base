package com.cheney.exception;

import com.cheney.bean.response.ResponseEntity;

public class RouteStopException extends RuntimeException {

    private ResponseEntity response = ResponseEntity.DEFAULT_ERROR_RESPONSE;

    public RouteStopException() {
    }

    public RouteStopException(ResponseEntity response) {
        this.response = response;
    }

    public RouteStopException(String message) {
        super(message);
    }

    public RouteStopException(String message, ResponseEntity response) {
        super(message);
        this.response = response;
    }

    public RouteStopException(String message, Throwable cause) {
        super(message, cause);
    }

    public RouteStopException(String message, Throwable cause, ResponseEntity response) {
        super(message, cause);
        this.response = response;
    }

    public RouteStopException(Throwable cause) {
        super(cause);
    }

    public RouteStopException(Throwable cause, ResponseEntity response) {
        super(cause);
        this.response = response;
    }

    public ResponseEntity getResponse() {
        return response;
    }

    public void setResponse(ResponseEntity response) {
        this.response = response;
    }
}
