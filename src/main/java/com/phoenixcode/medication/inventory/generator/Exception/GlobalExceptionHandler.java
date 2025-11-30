package com.phoenixcode.medication.inventory.generator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResidentNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResidentNotFoundExceptionHandler(ResidentNotFoundException ex,
                                                                          WebRequest webRequest) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .path(webRequest.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
