package com.phoenixcode.medication.inventory.generator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResidentNotFoundException.class)
    public ResponseEntity<ErrorResponse> residentNotFoundExceptionHandler(ResidentNotFoundException ex,
                                                                          WebRequest webRequest) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = generateResponse(ex, webRequest, status);

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(ResidentAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> residentAlreadyExistsExceptionHandler(ResidentAlreadyExistsException ex,
                                                                               WebRequest webRequest) {

        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse errorResponse = generateResponse(ex, webRequest, status);

        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse generateResponse(Exception ex, WebRequest request, HttpStatus status) {

        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .build();
    }
}
