package com.github.gabrielburich.courseapi.config.advicer;

import com.github.gabrielburich.courseapi.config.advicer.dto.ExceptionFieldDTO;
import com.github.gabrielburich.courseapi.config.advicer.dto.ExceptionInvalidFieldsDTO;
import com.github.gabrielburich.courseapi.config.advicer.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionInvalidFieldsDTO> handleValidationException(MethodArgumentNotValidException exception) {
        var invalidFields = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ExceptionFieldDTO(error.getField(), error.getDefaultMessage())).toList();
        var responseBody = new ExceptionInvalidFieldsDTO(HttpStatus.BAD_REQUEST.value(), invalidFields);
        return ResponseEntity.badRequest().body(responseBody);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        var responseBody = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getLocalizedMessage());
        return ResponseEntity.badRequest().body(responseBody);
    }

}
