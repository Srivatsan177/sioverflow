package com.srivatsan177.sioverflow.app.exceptions;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {
    private HttpStatus httpStatus;

    public RestException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public RestException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
