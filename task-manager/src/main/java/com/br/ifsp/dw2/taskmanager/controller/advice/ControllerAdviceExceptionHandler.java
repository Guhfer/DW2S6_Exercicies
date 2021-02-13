package com.br.ifsp.dw2.taskmanager.controller.advice;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> errors = new ArrayList<String>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        HttpStatus httpStatus = BAD_REQUEST;

        final var apiError
                = newStandardError(
                httpStatus,
                "Invalid Fields.",
                ((ServletWebRequest) request).getRequest().getRequestURI(),
                errors);

        return handleExceptionInternal(
                ex, apiError, headers, httpStatus, request);
    }


    private StandardError newStandardError(HttpStatus status, String titleError, String path, List<String> errors){
        return new StandardError(
                formatter.format(System.currentTimeMillis()),
                status.value(),
                titleError,
                path,
                errors);
    }

}

