package com.srivatsan177.sioverflow.app.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.srivatsan177.sioverflow.app.dtos.error.ErrorResponseDTO;
import com.srivatsan177.sioverflow.app.exceptions.RestException;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorResponseDTO> handleRestException(RestException ex) {
        return ResponseEntity.status(ex.getHttpStatus())
                .body(new ErrorResponseDTO(ex.getHttpStatus().value(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex) {
        log.error("Error occurred", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDTO(500, "Internal Server Error"));
    }
}
