package com.nanos.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    public ResponseEntity<List> validationExceptionHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.toString());
        });
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }
}
